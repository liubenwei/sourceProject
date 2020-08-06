package com.liu.sourceProject.myThreadPool.config;

import com.liu.sourceProject.myThreadPool.enums.QueueTypeEnum;
import com.liu.sourceProject.myThreadPool.enums.RejectedExecutionHandlerEnum;

import java.util.concurrent.TimeUnit;

public class ThreadPoolProperties {
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

	/**
	 * 队列的最大数量
	 */
	private int queueCapacity = Integer.MAX_VALUE;

	/**
	 * 队列类型
	 *
	 */
	private String queueType = QueueTypeEnum.LINKED_BLOCKING_QUEUE.getType();
	/**
	 * 是否公平策略
	 */
	private boolean fair;
	/**
	 * 拒绝策略
	 */
	private String rejectedExecutionType = RejectedExecutionHandlerEnum.ABORT_POLICY
			.getType();
	/**
	 * 空闲线程存活时间
	 */
	private long keepAliveTime;
	/**
	 * 时间单位
	 */
	private TimeUnit timeUnit;

	/**
	 * 队列容量阈值，超过此阈值报警
	 */
	private int queueCapacityThreshold = queueCapacity;
}
