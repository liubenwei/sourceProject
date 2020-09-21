package com.liu.sourceProject.leetcode.number400;

import com.liu.sourceProject.leetcode.TreeNode;

/**
 * @author liu
 * @Date 2020/9/21 19:12
 *
 *
计算给定二叉树的所有左叶子之和。

示例：

3
/ \
9  20
/  \
15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Number404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            return sumOfLeftLeaves(root.right) + root.left.val;
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
