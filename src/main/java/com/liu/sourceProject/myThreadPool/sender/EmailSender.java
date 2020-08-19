package com.liu.sourceProject.myThreadPool.sender;

import lombok.Data;

/**
 * @author liu
 * @Date 2020/8/11 19:12
 */
@Data
public class EmailSender {
	public String to;
	public String from;
	public String message;
}
