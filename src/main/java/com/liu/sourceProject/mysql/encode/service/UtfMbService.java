package com.liu.sourceProject.mysql.encode.service;

import java.util.List;

import com.liu.sourceProject.mysql.encode.entity.UtfMb;

/**
 * (UtfMb)表服务接口
 *
 * @author makejava
 * @since 2020-09-10 09:12:24
 */
public interface UtfMbService {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 实例对象
	 */
	UtfMb queryById(Integer id);

	/**
	 * 查询多条数据
	 *
	 * @param offset
	 *            查询起始位置
	 * @param limit
	 *            查询条数
	 * @return 对象列表
	 */
	List<UtfMb> queryAllByLimit(int offset, int limit);

	/**
	 * 新增数据
	 *
	 * @param utfMb
	 *            实例对象
	 * @return 实例对象
	 */
	UtfMb insert(UtfMb utfMb);

	/**
	 * 修改数据
	 *
	 * @param utfMb
	 *            实例对象
	 * @return 实例对象
	 */
	UtfMb update(UtfMb utfMb);

	/**
	 * 通过主键删除数据
	 *
	 * @param id
	 *            主键
	 * @return 是否成功
	 */
	boolean deleteById(Integer id);

}