package com.liu.sourceProject.leetcode.interview;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/11/9 17:26
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 *  
 *
 * 示例 1：
 *
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 *
 * 输入： 1->2->2->1
 * 输出： true
 *  
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 通过次数18,329提交次数39,104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number0206 {
	public static void main(String[] args) {
		boolean palindrome = new Number0206().isPalindrome(new ListNode(0));
		System.out.println(palindrome);
	}

	public boolean isPalindrome(ListNode head) {
		ListNode fast = head, slow = head, pre = new ListNode(0);
		pre.next = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			pre = pre.next;
		}
		pre.next = null;
		ListNode head1 = new ListNode(0);

		while (slow != null) {
			ListNode node = slow;
			slow = slow.next;
			node.next = head1.next;
			head1.next = node;
		}
		fast = head;
		slow = head1.next;
		while (fast != null) {
			if (fast.val != slow.val) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

}
