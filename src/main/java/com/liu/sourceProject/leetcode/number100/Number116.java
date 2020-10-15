package com.liu.sourceProject.leetcode.number100;

import com.liu.sourceProject.leetcode.Node;

/**
 * @author liu
 * @Date 2020/10/15 8:08
 */
public class Number116 {
    public Node connect(Node root) {
        Node pre = root,p = null;
        while( pre != null && pre.left != null){
            p = pre;
            while(p != null){
                p.left.next = p.right;
                if(p.next != null){
                    p.right.next = p.next.left;
                }
                p = p.next;
            }
            pre = pre.left;
        }
        return root;

    }
    public Node connect1(Node root) {
        if(root == null || root.left == null){
            return root;
        }
        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
