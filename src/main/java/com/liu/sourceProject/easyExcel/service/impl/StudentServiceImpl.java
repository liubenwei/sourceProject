package com.liu.sourceProject.easyExcel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import javax.annotation.Resource;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.liu.sourceProject.easyExcel.dao.StudentDao;
import com.liu.sourceProject.easyExcel.entity.Student;
import com.liu.sourceProject.easyExcel.service.StudentService;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-08-30 09:21:29
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDao studentDao;

	@Override
	public Set<String> findByNames(List<String> collegeNames) {
		return studentDao.findByNames(collegeNames);
	}

	@Override
	public List<Long> findByStudentNumber(List<Long> studentNumbers) {
		return studentDao.findByStudentNumbers(studentNumbers);
	}

	@Override
	public void batchInsert(List<Student> students, Consumer<List<Student>> consumer) {
		if(students == null || students.size() < 1){
			return ;
		}
		List<List<Student>> streamList = new ArrayList<>();
		for(int i =0 ; i < students.size(); i++){
			int j = Math.min( (i+1000),students.size() );
			List<Student> subList = students.subList(i,j);
			streamList.add(subList);
		}
		streamList.parallelStream().forEach(consumer);
	}

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 实例对象
	 */
	@Override
	public Student queryById(Object id) {
		return this.studentDao.queryById(id);
	}

	/**
	 * 查询多条数据
	 *
	 * @param offset
	 *            查询起始位置
	 * @param limit
	 *            查询条数
	 * @return 对象列表
	 */
	@Override
	public List<Student> queryAllByLimit(int offset, int limit) {
		return this.studentDao.queryAllByLimit(offset, limit);
	}

	/**
	 * 新增数据
	 *
	 * @param student
	 *            实例对象
	 * @return 实例对象
	 */
	@Override
	public Student insert(Student student) {
		this.studentDao.insert(student);
		return student;
	}

	/**
	 * 修改数据
	 *
	 * @param student
	 *            实例对象
	 * @return 实例对象
	 */
	@Override
	public Student update(Student student) {
		this.studentDao.update(student);
		return this.queryById(student.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id
	 *            主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Object id) {
		return this.studentDao.deleteById(id) > 0;
	}
}