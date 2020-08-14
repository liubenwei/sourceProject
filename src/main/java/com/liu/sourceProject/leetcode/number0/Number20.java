package com.liu.sourceProject.leetcode.number0;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liu
 * @Date 2020/8/14 8:40
 */
public class Number20 {
	public static void main(String[] args) {
		Number20 number20 = new Number20();
		boolean valid = number20.isValid("([)]");
		System.out.println(valid);
	}

	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Deque<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(')');
			} else if (s.charAt(i) == '[') {
				stack.push(']');
			} else if (s.charAt(i) == '{') {
				stack.push('}');
			} else if (stack.isEmpty() || !stack.pop().equals(s.charAt(i))) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
