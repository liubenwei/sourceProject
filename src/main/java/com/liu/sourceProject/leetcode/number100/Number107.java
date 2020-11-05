package com.liu.sourceProject.leetcode.number100;

import java.util.*;

/**
 * @author liu
 * @Date 2020/11/5 14:50
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * 通过次数107,644提交次数159,046
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> res=  new LinkedList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            List<Integer> temp = new ArrayList<>(size);
            for(int i = 0 ; i < size; i++){
                TreeNode treeNode = deque.remove();
                temp.add(treeNode.val);
                if(treeNode.left != null){
                    deque.add(treeNode.left);
                }
                if(treeNode.right != null){
                    deque.add(treeNode.right);
                }
            }
            res.addFirst(temp);
        }
        return res;
    }
}
