package com.liu.sourceProject.leetcode.number100;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/10/9 9:03
 */
public class Number141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
