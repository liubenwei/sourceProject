package com.liu.sourceProject.leetcode.weekCompetition.Number203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * @author liu
 * @Date 2020/8/23 11:36
 */
public class Number3 {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		Number3 number3 = new Number3();
		List<Integer> list = new ArrayList<>();
		Collections.sort(list);
		int m = 1;
		int[] arr = new int[] { 3, 5, 1, 2, 4 };
		int latestStep = number3.findLatestStep(arr, m);
		System.out.println(latestStep);
	}

	public int findLatestStep(int[] arr, int m) {
		int step = -1;
		char[] chars = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			chars[arr[i] - 1] = '1';
			if (dfs(chars, arr[i] - 1, m)) {
				step = i + 1;
			}
			String string = new String(chars);
			System.out.println("cahrs:" + string);
		}
		return step;
	}

	public boolean dfs(char[] chars, int index, int target) {
		int left = index - 1, right = index + 1, count = 1;
		while (left >= 0 && right < chars.length
				&& (chars[left] == '1' || chars[right] == '1')) {
			if (chars[left] == '1') {
				count++;
				left--;
			}
			if (chars[right] == '1') {
				count++;
				right++;
			}
		}
		if (count == target) {
			return true;
		}
		return false;
	}
}
