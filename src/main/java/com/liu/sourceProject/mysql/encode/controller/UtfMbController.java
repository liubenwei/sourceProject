package com.liu.sourceProject.mysql.encode.controller;

import javax.annotation.Resource;

import com.liu.sourceProject.source.code;
import org.springframework.web.bind.annotation.*;

import com.liu.sourceProject.mysql.encode.entity.UtfMb;
import com.liu.sourceProject.mysql.encode.service.UtfMbService;

/**
 * (UtfMb)表控制层
 *
 * @author makejava
 * @since 2020-09-10 09:12:24
 */
@RestController
@RequestMapping("utfMb")
public class UtfMbController {
	/**
	 * 服务对象
	 */
	@Resource
	private UtfMbService utfMbService;

	@PostMapping
	public String create(@RequestParam("code") String code) {
		UtfMb utfMb = new UtfMb();
		utfMb.setCode(code);
		utfMbService.insert(utfMb);
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
	public UtfMb selectOne(Integer id) {
		return this.utfMbService.queryById(id);
	}

}