package com.liu.sourceProject.leetcode.number200;

import java.util.HashMap;
import java.util.Map;

import com.liu.sourceProject.leetcode.ListNode;

public class Number237 {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

		}
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
