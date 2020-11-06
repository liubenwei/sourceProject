package com.liu.sourceProject.leetcode.interview;

/**
 * @author liu
 * @Date 2020/11/6 9:12
 *
URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）

示例1:

输入："Mr John Smith    ", 13
输出："Mr%20John%20Smith"
示例2:

输入："               ", 5
输出："%20%20%20%20%20"
提示：

字符串长度在[0, 500000]范围内。
通过次数21,446提交次数36,903
 */
public class Number0103 {
	public String replaceSpaces(String S, int length) {
		S = S.substring(0,length);
		int effectiveLength = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == ' ') {
				effectiveLength++;
			}
		}
		effectiveLength = effectiveLength * 2 + S.length();
		char[] chars = new char[effectiveLength];
		int curretnCharsIndex = 0;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == ' ') {
				chars[curretnCharsIndex++] = '%';
				chars[curretnCharsIndex++] = '2';
				chars[curretnCharsIndex++] = '0';
			} else {
				chars[curretnCharsIndex++] = S.charAt(i);
			}
		}
		return new String(chars);
	}
}
