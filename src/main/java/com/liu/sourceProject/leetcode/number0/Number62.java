package com.liu.sourceProject.leetcode.number0;

/**
 * @author liu
 * @Date 2020/12/9 8:31
 */
public class Number62 {
	public int uniquePaths(int m, int n) {
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 1;
				} else {
					matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
				}
			}
		}
		return matrix[m - 1][n - 1];
	}

	public int uniquePaths1(int m, int n) {
		int[] nums = new int[n];
		nums[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				nums[j] = nums[j] + nums[j - 1];
			}
		}
		return nums[n - 1];
	}
}
