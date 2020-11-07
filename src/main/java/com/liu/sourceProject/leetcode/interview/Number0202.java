package com.liu.sourceProject.leetcode.interview;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/11/7 8:57
 */
public class Number0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p  = head;
        int i = 0;
        while(p != null && i < k ){
            p = p.next;
            i++;
        }
        while(p != null){
            p = p.next;
            head = head.next;
        }
        return head.val;
    }
}
