package com.liu.sourceProject.mysql.encode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liu.sourceProject.mysql.encode.entity.Utf;

/**
 * (Utf)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-10 09:11:59
 */
public interface UtfDao {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 实例对象
	 */
	Utf queryById(Integer id);

	/**
	 * 查询指定行数据
	 *
	 * @param offset
	 *            查询起始位置
	 * @param limit
	 *            查询条数
	 * @return 对象列表
	 */
	List<Utf> queryAllByLimit(@Param("offset") int offset,
			@Param("limit") int limit);

	/**
	 * 通过实体作为筛选条件查询
	 *
	 * @param utf
	 *            实例对象
	 * @return 对象列表
	 */
	List<Utf> queryAll(Utf utf);

	/**
	 * 新增数据
	 *
	 * @param utf
	 *            实例对象
	 * @return 影响行数
	 */
	int insert(@Param("utf") Utf utf);

	/**
	 * 修改数据
	 *
	 * @param utf
	 *            实例对象
	 * @return 影响行数
	 */
	int update(Utf utf);

	/**
	 * 通过主键删除数据
	 *
	 * @param id
	 *            主键
	 * @return 影响行数
	 */
	int deleteById(Integer id);

}