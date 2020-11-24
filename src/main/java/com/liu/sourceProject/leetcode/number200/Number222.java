package com.liu.sourceProject.leetcode.number200;

import com.liu.sourceProject.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liu
 * @Date 2020/11/24 15:04
 */
public class Number222 {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        int res = 0;
        queue.offer(root);
        while(!queue.isEmpty()  ){
            int size = queue.size();
            res += size;
            for(int i =0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
