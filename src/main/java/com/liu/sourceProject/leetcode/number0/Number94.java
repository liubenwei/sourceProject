package com.liu.sourceProject.leetcode.number0;

import com.liu.sourceProject.leetcode.TreeNode;

import java.util.*;

/**
 * @author liu
 * @Date 2020/9/15 8:18
 */
public class Number94 {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        while(root != null || queue.peek() != null){
            while(root != null){
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }
}
