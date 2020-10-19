package com.liu.sourceProject.leetcode.number0;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/10/19 8:06
 *
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
public class Number19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode left = head, right = head;
        int index = 0;
        while(index < n){
            right = right.next;
            index++;
        }
        ListNode pre=  newHead;
        while(right != null){
            pre = pre.next;
            left = left.next;
            right = right.next;
        }
        pre.next = left.next;
        return newHead.next;
    }
}
