package com.liu.sourceProject.leetcode.number500;

import com.liu.sourceProject.leetcode.TreeNode;

/**
 * @author liu
 * @Date 2020/9/21 8:22
 */
public class Number538 {
    int num = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);
            root.val = root.val + num;
            num = root.val;
            convertBST(root.left);
            return root;
        }
        return null;
    }
}
