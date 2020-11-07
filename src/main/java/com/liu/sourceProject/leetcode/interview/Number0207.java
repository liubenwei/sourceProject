package com.liu.sourceProject.leetcode.interview;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/11/7 9:24
 */
public class Number0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA, h2 = headB;
        while(h1 != h2){
            h1 = h1 == null ? headB:h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }
}
