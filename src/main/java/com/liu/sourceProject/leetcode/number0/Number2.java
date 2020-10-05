package com.liu.sourceProject.leetcode.number0;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/10/5 9:34
 */
public class Number2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode pre = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode node = new ListNode(sumVal % 10);
            pre.next = node;
            pre = pre.next;

            if(l1 != null ){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return root.next;
    }
}
