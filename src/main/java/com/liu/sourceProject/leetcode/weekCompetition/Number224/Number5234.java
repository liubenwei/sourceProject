package com.liu.sourceProject.leetcode.weekCompetition.Number224;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 * @Date 2021/1/17 12:04
 */
public class Number5234 {
	public int tupleSameProduct(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>(nums.length / 2);
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int temp = nums[i] * nums[j];
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
				} else {
					map.put(temp, 1);
				}
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			res += (entry.getValue() * (entry.getValue() - 1)) >> 1;
		}
		return res * 8;
	}
}
