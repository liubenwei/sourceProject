package com.liu.sourceProject.leetcode.number0;

/**
 * @author liu
 * @Date 2020/12/1 8:51
 */
public class Number34 {
	public int[] searchRange(int[] nums, int target) {
		int[] res = new int[] { -1, -1 };
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				res[0] = i;
				break;
			}
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == target) {
				res[1] = i;
				break;
			}
		}
		return res;
	}
}
