package com.liu.sourceProject.myThreadPool.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Slf4j
@ConfigurationProperties(prefix = "dynamic.threadpools")
public class DynamicThreadPoolProperties {
	/**
	 * Nacos dataId, 监听修改配置用
	 */
	private String nacosDataId;

	/**
	 * Nacos,Group.
	 */
	private String nacosGroup;

	/**
	 * nacos等待配置刷新时间
	 */
	private int nacosWaitRefreshConfigSeconds = 1;
	/**
	 * 线程池名称
	 */
	private String threadPoolName = "crayonThreadPool";

	private String apolloNamespace;
	private String owner;

	/**
	 * 核心线程数
	 */
	private int corePoolSize = 1;



}
