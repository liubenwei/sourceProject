package com.liu.sourceProject.config.easyExcel;

import com.liu.sourceProject.easyExcel.handler.StudentImportHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu
 * @Date 2020/8/30 11:14
 */
@Configuration
public class EasyExcelConfiguration {
	@Bean
	public StudentImportHandler studentImportHandler() {
		return new StudentImportHandler();
	}
}
