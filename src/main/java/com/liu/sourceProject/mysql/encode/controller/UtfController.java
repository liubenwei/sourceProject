package com.liu.sourceProject.mysql.encode.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liu.sourceProject.mysql.encode.entity.Utf;
import com.liu.sourceProject.mysql.encode.service.UtfService;

/**
 * (Utf)表控制层
 *
 * @author makejava
 * @since 2020-09-10 09:12:00
 */
@RestController
@RequestMapping("utf")
public class UtfController {
	/**
	 * 服务对象
	 */
	@Resource
	private UtfService utfService;

	@PostMapping
	public String create(String code) {
		Utf utf = new Utf();
		utf.setCode(code);
		utfService.insert(utf);
		return "成功";
	}

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id
	 *            主键
	 * @return 单条数据
	 */
	@GetMapping("selectOne")
	public Utf selectOne(Integer id) {
		return this.utfService.queryById(id);
	}

}