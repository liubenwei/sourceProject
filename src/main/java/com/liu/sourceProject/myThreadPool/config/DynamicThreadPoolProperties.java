package com.liu.sourceProject.myThreadPool.config;

import lombok.Data;

@Data
public class DynamicThreadPoolProperties {
	/**
	 * 线程池名称
	 */
	private String threadPoolName = "crayonThreadPool";

	/**
	 * 核心线程数
	 */
	private int corePoolSize = 1;
	/**
	 * 最大线程数，默认值为Cpu核心的数量
	 */
	private int maximumPoolSize = Runtime.getRuntime().availableProcessors();

}
