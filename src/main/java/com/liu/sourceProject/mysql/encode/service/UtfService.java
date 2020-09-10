package com.liu.sourceProject.mysql.encode.service;

import java.util.List;

import com.liu.sourceProject.mysql.encode.entity.Utf;

/**
 * (Utf)表服务接口
 *
 * @author makejava
 * @since 2020-09-10 09:11:59
 */
public interface UtfService {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 实例对象
	 */
	Utf queryById(Integer id);

	/**
	 * 查询多条数据
	 *
	 * @param offset
	 *            查询起始位置
	 * @param limit
	 *            查询条数
	 * @return 对象列表
	 */
	List<Utf> queryAllByLimit(int offset, int limit);

	/**
	 * 新增数据
	 *
	 * @param utf
	 *            实例对象
	 * @return 实例对象
	 */
	Utf insert(Utf utf);

	/**
	 * 修改数据
	 *
	 * @param utf
	 *            实例对象
	 * @return 实例对象
	 */
	Utf update(Utf utf);

	/**
	 * 通过主键删除数据
	 *
	 * @param id
	 *            主键
	 * @return 是否成功
	 */
	boolean deleteById(Integer id);

}