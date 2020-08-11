package com.liu.sourceProject.myThreadPool.common;

/**
 * @author liu
 * @Date 2020/8/11 19:08
 */
public enum AlarmTypeEnum {
	/**
	 * 告警类型
	 */
	DING_TALK("DingTalk"), EMAIL("Email"), EXTERNAL_SYSTEM("ExternalSystem");

	private String type;

	AlarmTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
