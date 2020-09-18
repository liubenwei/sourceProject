package com.liu.sourceProject.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

/**
 * @author liu
 * @Date 2020/9/18 16:22
 */
public class LocalDateTimeTest {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(now.toLocalDate() + " " + now.toLocalTime());
		String timeToString = dateTimeFormatter.format(now);
		String string = DateTimeFormatter.ofPattern("HH:mm:ss").format(now.toLocalTime());
		System.out.println(timeToString);
		System.out.println(string);
	}
}
