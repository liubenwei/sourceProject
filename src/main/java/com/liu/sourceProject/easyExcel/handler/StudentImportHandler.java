package com.liu.sourceProject.easyExcel.handler;

import com.alibaba.excel.EasyExcel;
import com.liu.sourceProject.easyExcel.dao.StudentDao;
import com.liu.sourceProject.easyExcel.entity.Student;
import com.liu.sourceProject.easyExcel.form.ImportForm;
import com.liu.sourceProject.easyExcel.service.StudentService;
import com.liu.sourceProject.easyExcel.template.ExcelHeaderErrorTemplate;
import com.liu.sourceProject.easyExcel.validate.ValidateStudentContext;
import com.liu.sourceProject.easyExcel.validate.ValidateStudentResult;
import com.liu.sourceProject.ioc.annotation.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liu
 * @Date 2020/8/29 16:25
 *
 *       学生信息导入实现类
 */
@Slf4j
public class StudentImportHandler
		extends AbstractImportHandler<ImportForm, ValidateStudentResult> {
	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentDao studentDao;

	@Override
	public void handle(InputStream excel) {
		List<ImportForm> datas = null;
		try {
			datas = this.importData(excel);
		} catch (Exception e) {
			// 如果读取出了异常 直接返回 把文件地址放入redis
			String filePath = this.writeErrorToFile();
			log.info("文件地址:" + filePath);
		}
		ValidateStudentResult validateStudentResult = this.validate(datas);

		// 处理验证结果
		if (validateStudentResult.getError()) {
			// 把文件地址写入redis
			String filePath = this.writeErrorToFile(datas,
					validateStudentResult);
			log.info("文件地址:" + filePath);
		} else {
			long now = System.currentTimeMillis();
//			this.saveToDB(datas);
			log.info("导入时间:"+(System.currentTimeMillis() - now));
		}

	}

	@Override
	protected List<ImportForm> importData(InputStream excelInputStream) {
		StudentDataWorker worker = new StudentDataWorker();
		EasyExcel.read(excelInputStream, ImportForm.class, worker).sheet()
				.doRead();
		return worker.getDatas();
	}

	/**
	 * 验证数据的合法性
	 * 
	 * @param datas
	 *            excel读入的数据
	 * @return
	 */
	@Override
	protected ValidateStudentResult validate(List<ImportForm> datas) {
		ValidateStudentContext validateStudentContext = new ValidateStudentContext();
		ValidateStudentResult validateStudentResult = new ValidateStudentResult(
				validateStudentContext);

		// 验证非空字段
		this.validateNullField(datas, validateStudentResult);

		// 验证姓名 学院 学号
		this.validateObjectExistence(datas, validateStudentResult);
		if (this.hasErrorLineNum(validateStudentResult.getValidateContext())) {
			validateStudentResult.setError(true);
		}

		return validateStudentResult;
	}

	private boolean hasErrorLineNum(ValidateStudentContext validateContext) {
		return !validateContext.getCollegeNameErrorLineNum().isEmpty()
				&& !validateContext.getStudentNumberErrorLineNum().isEmpty();
	}

	private void validateObjectExistence(List<ImportForm> datas,
			ValidateStudentResult validateStudentResult) {
		validateStudentResult.getValidateContext()
				.setCollegeNameErrorLineNum(this.checkCollegeNames(datas));
		validateStudentResult.getValidateContext()
				.setStudentNumberErrorLineNum(this.checkStudentNumber(datas));

	}

	private List<Integer> checkStudentNumber(List<ImportForm> datas) {
		// 学号是数据库中不能存在，excel中也不能重复
		// 先验证excel中的学号是否存在数据库中 findIn 提示已经在数据库中
		List<Integer> studentNumberErrorNum = new ArrayList<>();
		//excel的set集合
		Set<Long> studentNumberSet = datas.stream()
				.map(ImportForm::getStudentNumber).collect(Collectors.toSet());
		List<Long> studentNumbers = datas.stream()
				.map(ImportForm::getStudentNumber).distinct()
				.collect(Collectors.toList());

		//求交集速度太慢，直接上for循环
		List<Long> studentNumberList = studentService
				.findByStudentNumber(studentNumbers);
		for (int i = 0; i < datas.size(); i++) {
			//如果数据库中存在这个学号
			if (studentNumbers.contains(datas.get(i).getStudentNumber())) {
				studentNumberErrorNum.add(i);
			}
			//如果
		}
		// 再验证excel中的学号是否重复 加入map contains判断 提示有重复数据 记录行号
		// 吧错误信息放到studentNumberErrorNumList里面
		return studentNumberErrorNum;
	}

	private List<Integer> checkCollegeNames(List<ImportForm> datas) {
		// 学院名称是数据库中必须存在，那么需要找出excel中存在但是数据库不存在的学院名称
		List<String> collegeNames = datas.stream()
				.map(ImportForm::getCollegeName).distinct()
				.collect(Collectors.toList());
		Set<String> collegeNameSet = studentService.findByNames(collegeNames);
		collegeNames.removeAll(collegeNameSet);
		List<Integer> collegeNamesErrorNum = new ArrayList<>();
		for (int i = 0; i < datas.size(); i++) {
			if (collegeNames.contains(datas.get(i).getCollegeName())) {
				collegeNamesErrorNum.add(i);
			}
		}
		return collegeNamesErrorNum;

	}

	@Override
	protected void saveToDB(List<ImportForm> datas) {
		List<Student> students = datas.stream().map(importForm -> {
			Student student = new Student();
			student.setCollegeName(importForm.getCollegeName());
			student.setStudentName(importForm.getStudentName());
			student.setStudentNumber(importForm.getStudentNumber());
			return student;
		}).collect(Collectors.toList());
		studentService.batchInsert(students, studentDao::batchInsert);

	}

	private String writeErrorToFile() {
		InputStream inputStream;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// 生成文件路劲
		String filePath = "D:\\tmp\\"
				+ UUID.randomUUID().toString().replace("-", "");
		File localFile = new File(filePath);
		List<ExcelHeaderErrorTemplate> excelHeaderErrorTemplates = new ArrayList<>();
		ExcelHeaderErrorTemplate template = new ExcelHeaderErrorTemplate();
		template.setError("请下载正确的导入模板");
		excelHeaderErrorTemplates.add(template);

		EasyExcel.write(outputStream, ExcelHeaderErrorTemplate.class)
				.inMemory(Boolean.TRUE).sheet("sheet1")
				.doWrite(excelHeaderErrorTemplates);
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		byte[] bytes = new byte[1024];
		int index = 0;
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				localFile)) {
			while ((index = inputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, index);
				fileOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return filePath;
	}

	@Override
	protected String writeErrorToFile(List<ImportForm> datas,
			ValidateStudentResult validateStudentResult) {

		// 如果验证过程中发现了错误,则把错误信息写入到excel
		InputStream inputStream;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		// 把数据写入到OutputStream
		EasyExcel.write(outputStream, ImportForm.class).inMemory(Boolean.TRUE)
				.registerWriteHandler(new StudentWriteHandler(
						validateStudentResult.getValidateContext()))
				.sheet("sheet1").doWrite(datas);
		String filePath = "D:\\tmp\\"
				+ UUID.randomUUID().toString().replace("-", "");
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
		File file = new File(filePath);
		int index;
		byte[] bytes = new byte[1024];
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filePath);
			while ((index = inputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, index);
				fileOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}

	private void validateNullField(List<ImportForm> datas,
			ValidateStudentResult validateStudentResult) {
		datas.forEach(importForm -> {
			if (Objects.isNull(importForm.getStudentName())) {
				validateStudentResult.setError(true);
				return;
			}
			if (Objects.isNull(importForm.getCollegeName())) {
				validateStudentResult.setError(true);
				return;
			}
			if (Objects.isNull(importForm.getStudentNumber())) {
				validateStudentResult.setError(true);
				return;
			}
		});
	}

}
