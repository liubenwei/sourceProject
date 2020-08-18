package com.liu.sourceProject.leetcode.number100;

import leetcode.editor.en.ListNode;

/**
 * @author liu
 * @Date 2020/8/18 20:21
 */
public class Number109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode pre = head;
        ListNode p = pre.next;
        ListNode q = p.next;
        while(q != null && q.next != null){
            pre = pre.next;
            p = p.next;
            q = q.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }
}
