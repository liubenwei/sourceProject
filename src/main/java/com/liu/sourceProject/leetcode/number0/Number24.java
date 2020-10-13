package com.liu.sourceProject.leetcode.number0;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/10/13 7:58
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 通过次数159,224提交次数237,905
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number24 {
    /**
     * pre -> p -> pNext -> ...
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(0),p, pNext;
        pre.next = head;
        p = head;
        pNext = head.next;
        head = pre;
        while(p != null && pNext != null){
            pre.next = pNext;
            p.next = pNext.next;
            pNext.next = p;

            pre= p;
            p = p.next;
            if(p != null){
                pNext = p.next;
            }
        }
        return head.next;
    }
}
