package com.liu.sourceProject.leetcode.number100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author liu
 * @Date 2020/9/29 9:01
 */
public class Number145 {

    List<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode pre = null;
        while (!nodeStack.isEmpty() || current != null) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            current = nodeStack.peek();
            if (current.right == null || current.right == pre) {
                res.add(current.val);
                pre = current;
                nodeStack.pop();
                current = null;
            } else {
                current = current.right;
            }
        }
        return res;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root != null) {
            postorderTraversal1(root.left);
            postorderTraversal1(root.right);
            res.add(root.val);
        }
        return res;
    }
}
