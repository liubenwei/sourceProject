package com.liu.sourceProject.easyExcel.form;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liu
 * @Date 2020/8/29 15:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportForm {
	/**
	 * 学生姓名
	 *
	 */
	@ExcelProperty(index = 0, value = "*姓名")
	private String studentName;

	/**
	 * 学号
	 */
	@ExcelProperty(index = 1, value = "*学号")
	private Long studentNumber;
	/**
	 * 学院
	 */
	@ExcelProperty(index = 2, value = "*学院")
	private String collegeName;
}
