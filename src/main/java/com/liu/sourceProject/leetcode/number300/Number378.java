package com.liu.sourceProject.leetcode.number300;

/**
 * @author liu
 * @Date 2020/10/9 16:24
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 *
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 *
 * 通过次数54,553提交次数86,828
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number378 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(new Number378().kthSmallest(matrix, 8));
	}

	int[] temp;
	int size;
	int colLength;

	public int kthSmallest(int[][] matrix, int k) {

		int rowLength = matrix.length;
		colLength = matrix[0].length;
		temp = new int[rowLength * colLength];
		size = colLength;
		for (int i = 0; i < colLength; i++) {
			temp[i] = matrix[0][i];
		}
		for (int i = 1; i < rowLength; i++) {
			if (temp[size - 1] < matrix[i][0] && size >= k) {
				return temp[k - 1];
			}
			merge(matrix[i]);
		}
		return temp[k -1];

	}

	public void merge(int[] row1) {
		int tmp = colLength - 1;
		int tmpSize = size - 1;
		int current = size + colLength - 1;
		while (tmp >= 0 && tmpSize >= 0) {
			if (temp[tmpSize] > row1[tmp]) {
				temp[current] = temp[tmpSize];
				current--;
				tmpSize--;
			} else {
				temp[current] = row1[tmp];
				current--;
				tmp--;
			}
		}
		while (tmp >= 0) {
			temp[current--] = row1[tmp--];
		}
		while (tmpSize >= 0) {
			temp[current--] = temp[tmpSize--];
		}
		size = size + colLength;
	}
}
