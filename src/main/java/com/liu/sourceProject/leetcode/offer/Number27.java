package com.liu.sourceProject.leetcode.offer;

import com.liu.sourceProject.leetcode.TreeNode;

/**
 * @author liu
 * @Date 2020/12/9 18:46
 */
public class Number27 {
	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return root;
		} else if (root.left != null && root.right != null) {
			TreeNode left = root.left;
			root.left = root.right;
			root.right = left;
			mirrorTree(root.left);
			mirrorTree(root.right);
			return root;
		} else if (root.left == null) {
			root.left = root.right;
			root.right = null;
			mirrorTree(root.left);
			return root;
		} else {
			root.right = root.left;
			root.left = null;
			mirrorTree(root.right);
			return root;
		}
	}
}
