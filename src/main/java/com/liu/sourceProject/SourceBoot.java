package com.liu.sourceProject;

import okhttp3.OkHttpClient;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author liu
 * @Date 2020/8/16 11:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan({"com.liu.sourceProject.easyExcel.dao","com.liu.sourceProject.mysql.encode.dao"})
public class SourceBoot {
	public static void main(String[] args) {

		DispatcherServlet dispatcherServlet;
		SpringApplication.run(SourceBoot.class,args);
	}

}
