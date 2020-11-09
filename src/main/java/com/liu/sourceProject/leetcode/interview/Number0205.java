package com.liu.sourceProject.leetcode.interview;

import com.liu.sourceProject.leetcode.ListNode;

/**
 * @author liu
 * @Date 2020/11/9 17:11
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?
 *
 * 示例：
 *
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * 通过次数16,710提交次数36,598
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryBit = 0;
        ListNode head = new ListNode(0), pre = head, p;
        while(l1 != null && l2 != null){
            p = new ListNode(0);
            int val = (l1.val + l2.val + carryBit) % 10;
            carryBit = (l1.val + l2.val + carryBit) / 10;
            p.val = val;
            pre.next = p;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            p = new ListNode(0);
            int val = (l1.val + carryBit) % 10;
            carryBit = (l1.val + carryBit) / 10;
            p.val = val;
            pre.next = p;
            pre = pre.next;
            l1 = l1.next;
        }
        while(l2 != null){
            p = new ListNode(0);
            int val = (l2.val + carryBit) % 10;
            carryBit = (l2.val + carryBit) / 10;
            p.val = val;
            pre.next = p;
            pre = pre.next;
            l2 = l2.next;
        }
        if(carryBit != 0){
            p = new ListNode(0);
            p.val = carryBit;
            pre.next = p;
            pre = pre.next;
        }
        return head.next;
    }
}
