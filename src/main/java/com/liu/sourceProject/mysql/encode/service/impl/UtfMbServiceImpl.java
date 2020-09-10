package com.liu.sourceProject.mysql.encode.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.sourceProject.mysql.encode.dao.UtfMbDao;
import com.liu.sourceProject.mysql.encode.entity.UtfMb;
import com.liu.sourceProject.mysql.encode.service.UtfMbService;

/**
 * (UtfMb)表服务实现类
 *
 * @author makejava
 * @since 2020-09-10 09:12:24
 */
@Service("utfMbService")
public class UtfMbServiceImpl implements UtfMbService {
	@Resource
	private UtfMbDao utfMbDao;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 实例对象
	 */
	@Override
	public UtfMb queryById(Integer id) {
		return this.utfMbDao.queryById(id);
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
	public List<UtfMb> queryAllByLimit(int offset, int limit) {
		return this.utfMbDao.queryAllByLimit(offset, limit);
	}

	/**
	 * 新增数据
	 *
	 * @param utfMb
	 *            实例对象
	 * @return 实例对象
	 */
	@Override
	public UtfMb insert(UtfMb utfMb) {
		this.utfMbDao.insert(utfMb);
		return utfMb;
	}

	/**
	 * 修改数据
	 *
	 * @param utfMb
	 *            实例对象
	 * @return 实例对象
	 */
	@Override
	public UtfMb update(UtfMb utfMb) {
		this.utfMbDao.update(utfMb);
		return this.queryById(utfMb.getId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param id
	 *            主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Integer id) {
		return this.utfMbDao.deleteById(id) > 0;
	}
}