package com.liu.sourceProject.leetcode.number0;

import com.liu.sourceProject.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liu
 * @Date 2020/8/8 22:29
 */
public class Number99 {
    public void recoverTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return ;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null , y = null, pre = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(pre != null && root.val < pre.val){
                y = root;
                if(x == null){
                    x = pre;
                }else{
                    break;
                }
            }
            pre = root;
            root = root.right;
        }
        swap(x,y);
    }
    public void swap(TreeNode x, TreeNode y){
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
