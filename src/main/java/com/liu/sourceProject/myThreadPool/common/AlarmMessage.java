package com.liu.sourceProject.myThreadPool.common;

import lombok.Builder;
import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author liu
 * @Date 2020/8/11 19:03
 */
@Data
@Builder
public class AlarmMessage {
	/**
	 * 告警名称，区分唯一性，方便控制告警间隔
	 */
	private String alarmName;

	/**
	 * 告警类型
	 */
	private AlarmTypeEnum alarmType;
	/**
	 * 告警消息
	 */
	private String message;

	private String accessToken;
	/**
	 * 对外api接口
	 */
	private String apiUrl;

	/**
	 * 告警时间间隔
	 */
	private int alarmTimeInterval = 1;

	/**
	 * 告警时间间隔单位
	 */
	private TimeUnit timeUnit;
}
