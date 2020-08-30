package com.liu.sourceProject.easyExcel.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.liu.sourceProject.easyExcel.entity.Student;

/**
 * (Student)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-30 09:21:27
 */
@Mapper
public interface StudentDao {

	Set<String> findByNames(@Param("collegeNames") List<String> collegeNames);

	void batchInsert(@Param("students") List<Student> students);

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 实例对象
	 */
	Student queryById(Object id);

	/**
	 * 查询指定行数据
	 *
	 * @param offset
	 *            查询起始位置
	 * @param limit
	 *            查询条数
	 * @return 对象列表
	 */
	List<Student> queryAllByLimit(@Param("offset") int offset,
			@Param("limit") int limit);

	/**
	 * 通过实体作为筛选条件查询
	 *
	 * @param student
	 *            实例对象
	 * @return 对象列表
	 */
	List<Student> queryAll(Student student);

	/**
	 * 新增数据
	 *
	 * @param student
	 *            实例对象
	 * @return 影响行数
	 */
	int insert(Student student);

	/**
	 * 修改数据
	 *
	 * @param student
	 *            实例对象
	 * @return 影响行数
	 */
	int update(Student student);

	/**
	 * 通过主键删除数据
	 *
	 * @param id
	 *            主键
	 * @return 影响行数
	 */
	int deleteById(Object id);

	List<Long> findByStudentNumbers(@Param("studentNumbers") List<Long> studentNumbers);
}