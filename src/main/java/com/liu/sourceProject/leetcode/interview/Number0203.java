package com.liu.sourceProject.leetcode.interview;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/11/7 9:07
 */
public class Number0203 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
