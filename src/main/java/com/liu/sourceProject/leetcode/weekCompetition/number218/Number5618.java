package com.liu.sourceProject.leetcode.weekCompetition.number218;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 * @Date 2020/12/6 11:03
 */
public class Number5618 {
	public int maxOperations(int[] nums, int k) {
		// num -> count
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for (int num : nums) {
			if (map.containsKey(k - num) && map.get(k - num) > 0) {
				res++;
				map.put(k - num, map.get(k - num) - 1);
			} else {
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}
			}

		}
		return res;
	}
}
