package com.liu.sourceProject.leetcode.number100;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/11/20 15:45
 */
public class Number147 {
	public static void main(String[] args) {
		int[] num = new int[] {-1, 4, 2, 1, 3 };
		ListNode head = new ListNode(0), p = head;
		int i = 0;
		while (i < 5) {
			p.next = new ListNode(num[i]);
			p = p.next;
			i++;
		}
		ListNode listNode = new Number147().insertionSortList(head.next);
		while (listNode != null) {
			System.out.print(listNode.val + " ");
			listNode = listNode.next;
		}
	}

	public ListNode insertionSortList(ListNode head) {

		ListNode newHead = new ListNode(0), currentNode = head, pre;
		newHead.next = head;
		while(currentNode != null && currentNode.next != null){
			if(currentNode.val <= currentNode.next.val){
				currentNode = currentNode.next;
				continue;
			}
			pre = newHead;
			while(pre.next.val < currentNode.next.val){
				pre = pre.next;
			}
			ListNode temp = currentNode.next;
			currentNode.next = temp.next;
			temp.next = pre.next;
			pre.next = temp;
		}
		return newHead.next;
	}
}
