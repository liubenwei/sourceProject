package com.liu.sourceProject.leetcode.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu
 * @Date 2020/11/6 9:01
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * 通过次数29,474提交次数44,613
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number0102 {
	public boolean CheckPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int[] arr = new int[128];
		for (int i = 0; i < s1.length(); i++) {
			arr[s1.charAt(i)]++;
			arr[s2.charAt(i)]--;
		}
		for (int value : arr) {
			if (value != 0) {
				return false;
			}
		}
		return true;
	}

}
