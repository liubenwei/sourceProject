package com.liu.sourceProject.leetcode.number500;

import com.liu.sourceProject.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author liu
 * @Date 2020/11/5 15:10
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *  
 *
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * 通过次数23,052提交次数32,114
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number513 {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            TreeNode firstNode = deque.peek();
            for(int i = 0; i < size; i++){
                TreeNode treeNode = deque.poll();
                if(treeNode.left != null){
                    deque.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    deque.offer(treeNode.right);
                }
            }
            if(deque.isEmpty()){
                return firstNode.val;
            }
        }
        return 0;
    }
}
