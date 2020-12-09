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
}
