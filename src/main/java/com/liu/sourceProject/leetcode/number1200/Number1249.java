package com.liu.sourceProject.leetcode.number1200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liu
 * @Date 2020/10/14 14:21
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 *  
 *
 * 示例 1：
 *
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 *
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 *
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * 示例 4：
 *
 * 输入：s = "(a(b(c)d)"
 * 输出："a(b(c)d)"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s[i] 可能是 '('、')' 或英文小写字母
 * 通过次数10,968提交次数19,302
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1249 {
	public static void main(String[] args) {
		String s = new Number1249().minRemoveToMakeValid2("lee(t(c)o)de)");
		System.out.println(s);
	}

	public String minRemoveToMakeValid(String s) {
		char[] charArray = s.toCharArray();
		Deque<Integer> deque = new ArrayDeque<>();
		Set<Integer> errorIndex = new HashSet<>();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '(') {
				deque.push(i);
			} else if (charArray[i] == ')') {
				if (deque.isEmpty()) {
					errorIndex.add(i);
				} else {
					deque.pop();
				}
			}
		}
		while (!deque.isEmpty()) {
			errorIndex.add(deque.pop());
		}
		StringBuilder sb = new StringBuilder("");
		System.out.println("size" + errorIndex.size());
		for (int i = 0; i < charArray.length; i++) {
			if (errorIndex.contains(i)) {
				continue;
			}
			sb.append(charArray[i]);
		}
		return sb.toString();
	}

	public String minRemoveToMakeValid2(String s) {
		char[] charArray = s.toCharArray();
		Deque<Integer> deque = new ArrayDeque<>();
		Set<Integer> errorIndex = new HashSet<>();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '(') {
				deque.push(i);
			} else if (charArray[i] == ')') {
				if (deque.isEmpty() || charArray[deque.peek()] != '(') {
					deque.push(i);
				} else {
					deque.pop();
				}
			}
		}
		System.out.println(deque.size());
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < charArray.length; i++) {
			if (!deque.isEmpty() && i == deque.peekLast()) {
				deque.removeLast();
				continue;
			}
			sb.append(charArray[i]);
		}
		return sb.toString();
	}
}
