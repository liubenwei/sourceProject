package com.liu.sourceProject.easyExcel.handler;

import com.alibaba.excel.EasyExcel;
import com.liu.sourceProject.easyExcel.form.ImportForm;
import com.liu.sourceProject.easyExcel.template.ExcelHeaderErrorTemplate;
import com.liu.sourceProject.easyExcel.validate.ValidateResult;
import com.liu.sourceProject.easyExcel.validate.ValidateStudentContext;
import com.liu.sourceProject.easyExcel.validate.ValidateStudentResult;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author liu
 * @Date 2020/8/29 16:25
 *
 *       学生信息导入实现类
 */
@Slf4j
public class StudentImportHandler
		extends AbstractImportHandler<ImportForm, ValidateStudentResult> {

	@Override
	public void handle(InputStream excel) {
		List<ImportForm> datas = null;
		try {
			datas = this.importData(excel);
		} catch (Exception e) {
			// 如果读取出了异常 直接返回 把文件地址放入redis
			this.writeErrorToFile();
		}
		ValidateStudentResult validateStudentResult = this.validate(datas);

		// 处理验证结果
		if (validateStudentResult.getError()) {
			// 把文件地址写入redis
			this.writeErrorToFile(datas, validateStudentResult);
		} else {
			this.saveToDB(datas);
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
	protected ValidateStudentResult validate(List datas) {
		ValidateStudentContext validateStudentContext = new ValidateStudentContext();
		ValidateStudentResult validateStudentResult = new ValidateStudentResult(validateStudentContext);

		//验证非空字段
		this.validateNullField(datas,validateStudentResult);

		//验证姓名 学院 学号
		this.validateObjectExistence(datas,validateStudentResult);

		return null;
	}

	private void validateObjectExistence(List datas, ValidateStudentResult validateStudentResult) {

	}


	@Override
	protected void saveToDB(List datas) {

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
			ValidateStudentResult validateContext) {
		return null;
	}

	private void validateNullField(List datas, ValidateStudentResult validateStudentResult) {

	}
}
