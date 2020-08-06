package com.liu.sourceProject.myThreadPool.enums;

/**
 * @author liu
 * @Date 2020/8/5 21:10
 */
public enum RejectedExecutionHandlerEnum {
	/**
	 * 线程池的拒绝策略
	 */
	CALLER_RUNS_POLICY("CallerRunsPolicy"), ABORT_POLICY(
			"AbortPolicy"), DISCARD_POLICY(
					"DiscardPolicy"), DISCARD_OLDEST_POLICY(
							"DiscardOldestPolicy");

	String type;

	RejectedExecutionHandlerEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static boolean exists(String type) {
		for (RejectedExecutionHandlerEnum rejectedExecutionHandlerEnum : RejectedExecutionHandlerEnum
				.values()) {
			if (rejectedExecutionHandlerEnum.getType().equals(type)) {
				return true;
			}
		}
		return false;
	}
}
