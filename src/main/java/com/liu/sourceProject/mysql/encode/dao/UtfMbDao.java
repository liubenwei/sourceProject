package com.liu.sourceProject.mysql.encode.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liu.sourceProject.mysql.encode.entity.UtfMb;

/**
 * (UtfMb)表数据库访问层
 *
 * @author makejava
 * @since 2020-09-10 09:12:23
 */
public interface UtfMbDao {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 实例对象
	 */
	UtfMb queryById(Integer id);

	/**
	 * 查询指定行数据
	 *
	 * @param offset
	 *            查询起始位置
	 * @param limit
	 *            查询条数
	 * @return 对象列表
	 */
	List<UtfMb> queryAllByLimit(@Param("offset") int offset,
			@Param("limit") int limit);

	/**
	 * 通过实体作为筛选条件查询
	 *
	 * @param utfMb
	 *            实例对象
	 * @return 对象列表
	 */
	List<UtfMb> queryAll(UtfMb utfMb);

	/**
	 * 新增数据
	 *
	 * @param utfMb
	 *            实例对象
	 * @return 影响行数
	 */
	int insert(@Param("utfMb") UtfMb utfMb);

	/**
	 * 修改数据
	 *
	 * @param utfMb
	 *            实例对象
	 * @return 影响行数
	 */
	int update(UtfMb utfMb);

	/**
	 * 通过主键删除数据
	 *
	 * @param id
	 *            主键
	 * @return 影响行数
	 */
	int deleteById(Integer id);

}