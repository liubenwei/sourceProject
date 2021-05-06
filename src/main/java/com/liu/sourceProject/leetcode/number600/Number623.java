package com.liu.sourceProject.leetcode.number600;

import com.liu.sourceProject.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liu
 * @Date 2020/10/13 8:36
 * <p>
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 * <p>
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 * <p>
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 * <p>
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /   \
 * 2     6
 * / \   /
 * 3   1 5
 * <p>
 * v = 1
 * <p>
 * d = 2
 * <p>
 * 输出:
 * 4
 * / \
 * 1   1
 * /     \
 * 2       6
 * / \     /
 * 3   1   5
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * 二叉树如下所示:
 * 4
 * /
 * 2
 * / \
 * 3   1
 * <p>
 * v = 1
 * <p>
 * d = 3
 * <p>
 * 输出:
 * 4
 * /
 * 2
 * / \
 * 1   1
 * /     \
 * 3       1
 * 注意:
 * <p>
 * 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
 * 输入的二叉树至少有一个节点。
 * 通过次数6,465提交次数12,033
 */
public class Number623 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        int currentDepth = 2;
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode head = root;
        queue.add(head);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentDepth == d) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    TreeNode leftNode = new TreeNode(v);
                    if (node.left != null) {
                        leftNode.left = node.left;
                    }
                    node.left = leftNode;

                    TreeNode rightNode = new TreeNode(v);
                    if (node.right != null) {
                        rightNode.right = node.right;
                    }
                    node.right = rightNode;
                }
                return head;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            currentDepth++;
        }
        return head;

    }
}
