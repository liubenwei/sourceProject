package com.liu.sourceProject.easyExcel.controller;

import com.liu.sourceProject.easyExcel.handler.StudentImportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author liu
 * @Date 2020/8/30 10:34
 */
@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentImportHandler studentImportHandler;

	@PostMapping("/import")
	public void importStudent(@RequestParam("file") MultipartFile excel) throws IOException {
		studentImportHandler.handle(excel.getInputStream());
	}
}
