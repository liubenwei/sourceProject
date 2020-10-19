package com.liu.sourceProject.leetcode.number100;

import com.alibaba.fastjson.JSON;
import com.liu.sourceProject.leetcode.Node;
import lombok.Data;

/**
 * @author liu
 * @Date 2020/10/15 8:08
 */
@Data
public class Number116 {
	String asdf = "asdf";
	Integer age = 123;
	public static void main(String[] args) {
		Number116 number116 = new Number116();

		String string = JSON.toJSONString(number116);
		System.out.println(string);
	}

	public Node connect(Node root) {
		Node pre = root, p = null;
		while (pre != null && pre.left != null) {
			p = pre;
			while (p != null) {
				p.left.next = p.right;
				if (p.next != null) {
					p.right.next = p.next.left;
				}
				p = p.next;
			}
			pre = pre.left;
		}
		return root;

	}

	public Node connect1(Node root) {
		if (root == null || root.left == null) {
			return root;
		}
		root.left.next = root.right;
		if (root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
		return root;
	}
}
