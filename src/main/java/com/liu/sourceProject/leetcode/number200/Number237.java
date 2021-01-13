package com.liu.sourceProject.leetcode.number200;

import com.liu.sourceProject.leetcode.ListNode;

public class Number237 {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
