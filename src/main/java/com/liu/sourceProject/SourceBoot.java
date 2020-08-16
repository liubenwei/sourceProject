package com.liu.sourceProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author liu
 * @Date 2020/8/16 11:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SourceBoot {
	public static void main(String[] args) {
		SpringApplication.run(SourceBoot.class,args);
	}

}
