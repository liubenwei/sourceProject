package com.liu.sourceProject.leetcode.number300;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author liu
 * @Date 2020/11/11 17:13
 *
给定两个数组，编写一个函数来计算它们的交集。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]


说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
通过次数139,480提交次数190,520
 */
public class Number349 {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return new int[0];
		}
		Set<Integer> set = new HashSet<>();
		Set<Integer> resSet = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		for (int num : nums2) {
			if (set.contains(num)) {
				resSet.add(num);
			}
		}
		int[] res = new int[resSet.size()];
		int i = 0;
		Iterator<Integer> iterator = resSet.iterator();
		while (iterator.hasNext()) {
			Integer next = iterator.next();
			res[i++] = next;
			iterator.remove();
		}
		return res;
	}
}
