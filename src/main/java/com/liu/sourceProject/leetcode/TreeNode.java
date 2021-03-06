package com.liu.sourceProject.leetcode;
import static org.junit.jupiter.api.Assertions.*;

import lombok.Data;

@Data
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode (){}
	public TreeNode(int x) {
		val = x;
	}

	public TreeNode(int val,TreeNode left,TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
