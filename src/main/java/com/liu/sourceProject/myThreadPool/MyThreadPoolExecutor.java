package com.liu.sourceProject.myThreadPool;

import java.util.Map;
import java.util.concurrent.*;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {
	private String threadPoolName;

	private String defaultTaskName = "defaultTask";

	private Map<String, String> runnableNameMap = new ConcurrentHashMap<>();

	private static final RejectedExecutionHandler defaultHandler = new ThreadPoolExecutor.AbortPolicy();

	public MyThreadPoolExecutor(int corePoolSize, int maximunPoolSize,
			long keepAliveTime, TimeUnit timeUnit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximunPoolSize, keepAliveTime, timeUnit,
				workQueue);
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit timeUnit,
			BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler,
			String threadPoolName) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, workQueue,
				handler);
		this.threadPoolName = threadPoolName;
	}

	public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit timeUnit,
			BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, workQueue,
				threadFactory, defaultHandler);
	}

}
