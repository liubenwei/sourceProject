package com.liu.sourceProject.leetcode.interview;

/**
 * @author liu
 * @Date 2020/11/16 8:29
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 * 通过次数36,805提交次数67,903
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-merge-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1001 {
	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] B = new int[] { 2, 5, 6 };
		Number1001 number1001 = new Number1001();
		number1001.merge(A, 3, B, 3);
		System.out.println(A);
	}

	public void merge(int[] A, int m, int[] B, int n) {
		int aIndex = A.length - 1;
		m = m - 1;
		n = n - 1;
		while (m >= 0 && n >= 0) {
			if (A[m] > B[n]) {
				A[aIndex--] = A[m--];

			} else {
				A[aIndex--] = B[n--];
			}
		}
		while (m >= 0) {
			A[aIndex--] = A[m--];

		}
		while (n >= 0) {
			A[aIndex--] = B[n--];

		}
	}
}
