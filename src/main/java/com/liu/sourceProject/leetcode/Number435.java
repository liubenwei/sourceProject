package com.liu.sourceProject.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liu
 * @Date 2020/12/31 16:26
 */
public class Number435 {
	public int eraseOverlapIntervals(int[][] intervals) {
		int res = 0;
		if (intervals == null || intervals.length == 0
				|| intervals[0].length == 0) {
			return res;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a1, int[] a2) {
				return a1[1] - a2[1];
			}
		});
		res = 1;
		int end = intervals[0][1];
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] < end) {
				continue;
			}
			end = intervals[i][1];
			res++;
		}
		return intervals.length - res;
	}
}
