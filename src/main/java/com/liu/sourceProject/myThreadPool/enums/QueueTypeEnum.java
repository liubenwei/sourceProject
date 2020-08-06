package com.liu.sourceProject.myThreadPool.enums;

/**
 * @author liu
 * @Date 2020/8/5 21:02
 */
public enum QueueTypeEnum {
	/**
	 * 队列类型
	 */
	LINKED_BLOCKING_QUEUE("LinkedBlockingQueue"), SYNCHRONOUS_QUEUE(
			"SynchronousQueue"), ARRAY_BLOCKING_QUEUE(
					"ArrayBlockingQueue"), DELAY_QUEUE(
							"DelayQueue"), LINKED_TRANSFER_DEQUE(
									"LinkedTransferDeque"), LINKED_BLOCKING_DUQUE(
											"LinkedBlockingDeque"), PRIORITY_BLOCKING_QUEUE(
													"PriorityBlockingQueue");

	String type;

	QueueTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public static boolean exists(String type) {
		for (QueueTypeEnum typeEnum : QueueTypeEnum.values()) {
			if (typeEnum.getType().equals(type)) {
				return true;
			}
		}
		return false;
	}
}
