package com.liu.sourceProject.leetcode.number200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 * @Date 2020/12/16 16:55
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number290 {
	public boolean wordPattern(String pattern, String s) {
		if (pattern == null && s == null) {
			return true;
		}
		if (pattern == null || s == null) {
			return false;
		}
		Map<Character, String> map = new HashMap<>();
		String[] strings = s.split(" ");
		if (pattern.length() != strings.length) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			Character c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!strings[i].equals(map.get(c))) {
					return false;
				}
			} else {
				if (map.containsValue(strings[i])) {
					return false;
				}
				map.put(c, strings[i]);
			}
		}
		return true;
	}
}