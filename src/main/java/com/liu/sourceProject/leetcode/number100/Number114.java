package com.liu.sourceProject.leetcode.number100;

//给定一个二叉树，原地将它展开为一个单链表。
//
//         
//
//        例如，给定二叉树
//
//        1
//        / \
//        2   5
//        / \   \
//        3   4   6
//        将其展开为：
//
//        1
//        \
//        2
//        \
//        3
//        \
//        4
//        \
//        5
//        \
//        6
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Number114 {

    public void flatten(TreeNode root) {
        while (root != null) {
            TreeNode left = root.left;
            if (left != null) {
                TreeNode last = left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = root.right;
                root.right = left;
                root.left = null;
            }
            System.out.println(root.val);
            root = root.right;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
