package com.liu.sourceProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author liu
 * @Date 2020/8/16 11:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SourceBoot {
	public static void main(String[] args) {

		DispatcherServlet dispatcherServlet;
		SpringApplication.run(SourceBoot.class,args);
	}

}
