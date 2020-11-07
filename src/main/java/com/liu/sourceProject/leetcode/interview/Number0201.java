package com.liu.sourceProject.leetcode.interview;

import com.liu.sourceProject.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liu
 * @Date 2020/11/7 8:48
 */
public class Number0201 {

    public ListNode removeDuplicateNodes1(ListNode head) {
        if(head == null){
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode newHead = new ListNode(0),pre;
        newHead.next = head;
        pre = newHead;
        while(head != null){
            if(set.contains(head.val)){
                pre.next = head.next;
                head = head.next;
            }else{
                set.add(head.val);
                pre = pre.next;
                head = head.next;
            }
        }
        return newHead.next;
    }
}
