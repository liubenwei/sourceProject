package com.liu.sourceProject.mysql.encode.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liu.sourceProject.mysql.encode.dao.UtfDao;
import com.liu.sourceProject.mysql.encode.entity.Utf;
import com.liu.sourceProject.mysql.encode.service.UtfService;

/**
 * (Utf)表服务实现类
 *
 * @author makejava
 * @since 2020-09-10 09:12:00
 */
@Service("utfService")
public class UtfServiceImpl implements UtfService {
	@Resource
	private UtfDao utfDao;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 实例对象
	 */
	@Override
	public Utf queryById(Integer id) {
		return this.utfDao.queryById(id);
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
	public List<Utf> queryAllByLimit(int offset, int limit) {
		return this.utfDao.queryAllByLimit(offset, limit);
	}

	/**
	 * 新增数据
	 *
	 * @param utf
	 *            实例对象
	 * @return 实例对象
	 */
	@Override
	public Utf insert(Utf utf) {
		this.utfDao.insert(utf);
		return utf;
	}

	/**
	 * 修改数据
	 *
	 * @param utf
	 *            实例对象
	 * @return 实例对象
	 */
	@Override
	public Utf update(Utf utf) {
		this.utfDao.update(utf);
		return this.queryById(utf.getId());
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
		return this.utfDao.deleteById(id) > 0;
	}
}