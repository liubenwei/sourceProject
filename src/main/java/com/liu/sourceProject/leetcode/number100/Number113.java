package com.liu.sourceProject.leetcode.number100;

import java.util.*;

/**
 * @author liu
 * @Date 2020/9/26 14:51
 *     List<List<Integer>> nodePool = new ArrayList<>();
 *     List<Integer> tmp = new ArrayList<>();
 *     int target;
 *     public List<List<Integer>> pathSum(TreeNode root, int sum) {
 *         this.target = sum;
 *         dfs(root, 0);
 *         return nodePool;
 *     }
 *
 *     private void dfs(TreeNode root, int sum){
 *         if(root == null) return;
 *         tmp.add(root.val);
 *         sum += root.val;
 *         if(sum == target && root.left == null && root.right == null) nodePool.add(new ArrayList<>(tmp));
 *         dfs(root.left, sum);
 *         dfs(root.right, sum);
 *         tmp.remove(tmp.size() - 1);
 *         sum -= root.val;
 *     }
 */
public class Number113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // if(root == null || root.val > sum){
        //     return new ArrayList<>();
        // }
        this.target = sum;
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode root, int sum){
        if(root == null){
            return ;
        }
        sum += root.val;
        temp.add(root.val);
        if(sum == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(temp));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        temp.remove(temp.size() - 1);
        sum -= root.val;
        
    }
}
