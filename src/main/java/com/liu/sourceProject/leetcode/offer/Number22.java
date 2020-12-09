package com.liu.sourceProject.leetcode.offer;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/12/9 18:34
 */
public class Number22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head, last = head;
        while(k  > 0){
            k--;
            last = last.next;
        }
        while(last != null){
            pre  = pre.next;
            last = last.next;
        }
        return pre;
    }
}
