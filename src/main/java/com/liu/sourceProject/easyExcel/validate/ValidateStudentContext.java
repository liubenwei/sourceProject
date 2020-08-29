package com.liu.sourceProject.easyExcel.validate;

import lombok.Data;

import java.util.List;

/**
 * @author liu
 * @Date 2020/8/29 16:01
 */
@Data
public class ValidateStudentContext {
	/**
	 * 姓名的错误行号集合
	 */
	private List<Integer> studentNameErrorLineNum;
	/**
	 * 学号的错误行号集合
	 */
	private List<Integer> studentNumberErrorLineNum;
	/**
	 * 学院的错误行号集合
	 */
	private List<Integer> collegeNameErrorLineNum;
}
