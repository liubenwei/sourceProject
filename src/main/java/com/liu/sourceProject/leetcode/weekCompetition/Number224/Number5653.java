package com.liu.sourceProject.leetcode.weekCompetition.Number224;

/**
 * @author liu
 * @Date 2021/1/17 12:04
 */
public class Number5653 {
	public int countGoodRectangles(int[][] rectangles) {
		if (rectangles == null || rectangles.length == 0
				|| rectangles[0].length == 0) {
			return 0;
		}
		int maxLength = 0;
		int maxLengthCount = 0;
		for (int i = 0; i < rectangles.length; i++) {
			int length = Math.min(rectangles[i][0], rectangles[i][1]);
			if (length > maxLength) {
				maxLength = length;
				maxLengthCount = 1;
			} else if (length == maxLength) {
				maxLengthCount++;
			}
		}
		return maxLengthCount;
	}
}
