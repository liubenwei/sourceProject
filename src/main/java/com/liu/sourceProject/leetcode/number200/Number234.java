package com.liu.sourceProject.leetcode.number200;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/10/23 18:27
 */
public class Number234 {
    public boolean isPalindrome(ListNode head) {
        ListNode head1 = new ListNode(0),head2 = new ListNode(0),slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while(true){

        }


    }
}
