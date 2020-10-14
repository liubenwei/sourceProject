package com.liu.sourceProject.leetcode.number0;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/10/14 14:00
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * 通过次数90,457提交次数223,276
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int length = 0, offset;
        ListNode p = head,newHead,last= null;
        newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        while(p != null){
            last= p;
            p = p.next;
            length++;
        }
        offset = k % length;
        if(offset == 0){
            return head.next;
        }
        p = head.next;
        for(int i =0 ; i < (length - offset) - 1; i++){
            p= p.next;
        }
        last.next = head.next;
        newHead = p.next;
        p.next = null;
        return newHead;

    }
}
