package com.liu.sourceProject.easyExcel.template;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author liu
 * @Date 2020/8/29 15:42
 */
@Data
public class ExcelHeaderErrorTemplate {
	@ExcelProperty("错误信息")
	private String error;
}
