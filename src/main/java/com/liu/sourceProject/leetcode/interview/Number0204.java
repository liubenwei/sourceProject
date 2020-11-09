package com.liu.sourceProject.leetcode.interview;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/11/9 17:44
 *
编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。

示例:

输入: head = 3->5->8->5->10->2->1, x = 5
输出: 3->1->2->10->5->5->8
通过次数13,134提交次数20,359
 */
public class Number0204 {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 5, 8, 5, 10, 2, 1 };
		ListNode head = new ListNode(0), p = head;
		for (int i = 0; i < arr.length; i++) {
			p.next = new ListNode(arr[i]);
			p = p.next;
		}
		Number0204 number0204 = new Number0204();
		ListNode partition = number0204.partition(head, 5);

	}

	public ListNode partition(ListNode head, int x) {
		ListNode head1 = new ListNode(0), head2 = new ListNode(0), pre1, pre2;
		pre1 = head1;
		pre2 = head2;
		while (head != null) {
			ListNode node = head;

			head = head.next;
			node.next = null;
			if (node.val < x) {
				pre2.next = node;
				pre2 = pre2.next;
			} else {
				pre1.next = node;
				pre1 = pre1.next;
			}
		}
		pre2.next = head1.next;
		return head2.next;

	}
}
