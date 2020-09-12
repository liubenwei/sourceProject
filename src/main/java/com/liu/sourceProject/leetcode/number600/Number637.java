package com.liu.sourceProject.leetcode.number600;

import com.liu.sourceProject.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author liu
 * @Date 2020/9/12 10:56
 */
public class Number637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.add(root);
        while(queue.size() != 0){
            int length = queue.size();
            double sum = 0;
            for(int i =0 ; i < length; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(sum/length);
        }
        return result;
    }
}
