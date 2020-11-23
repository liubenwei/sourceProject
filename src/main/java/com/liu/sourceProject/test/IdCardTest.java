package com.liu.sourceProject.test;

import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liu
 * @Date 2020/9/3 19:50
 */
public class IdCardTest {
	public static void main(String[] args) {
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 43; i++) {
			int number = random.nextInt(string.length());
			stringBuilder.append(string.charAt(number));
		}
		System.out.println(stringBuilder.toString());
		Base64.decodeBase64("asdf");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list);

		// System.out.println("中共问");
		// String reges = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\\S]{8,16}$";
		// Pattern passwordPattern = Pattern.compile(reges);
		// Matcher matcher = passwordPattern.matcher("iiuie01?");
		// System.out.println(matcher.matches());

		// String regex=
		// "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
		// "362425199807230450".matches(regex);
		// System.out.println("360430199603200322".matches(regex));
	}
}
