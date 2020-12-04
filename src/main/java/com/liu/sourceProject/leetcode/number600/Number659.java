package com.liu.sourceProject.leetcode.number600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 * @Date 2020/12/4 20:09
 */
public class Number659 {
	public boolean isPossible(int[] nums) {
		Map<Integer, Integer> freq = new HashMap<>(), need = new HashMap<>();
		for (Integer num : nums) {
			if (freq.containsKey(num)) {
				freq.put(num, freq.get(num) + 1);
			} else {
				freq.put(num, 1);
			}
		}
		for (Integer num : nums) {
			if (freq.get(num) == 0) {
				continue;
			}
			if (need.containsKey(num) && need.get(num) > 0) {
				need.put(num, need.get(num) - 1);
				if (need.containsKey(num + 1)) {
					need.put(num + 1, need.get(num + 1) + 1);
				} else {
					need.put(num + 1, 1);
				}
			} else if (freq.containsKey(num + 1) && freq.containsKey(num + 2)
					&& freq.get(num + 1) > 0 && freq.get(num + 2) > 0) {
				freq.put(num + 1, freq.get(num + 1) - 1);
				freq.put(num + 2, freq.get(num + 2) - 1);
				if (need.containsKey(num + 3)) {
					need.put(num + 3, need.get(num + 3) + 1);
				} else {
					need.put(num + 3, 1);
				}
			} else {
				return false;
			}
			freq.put(num, freq.get(num) - 1);
		}
		return true;
	}
}
