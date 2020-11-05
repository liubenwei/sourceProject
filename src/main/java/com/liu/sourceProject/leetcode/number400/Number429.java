package com.liu.sourceProject.leetcode.number400;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author liu
 * @Date 2020/11/5 15:24
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *  
 *
 *
 *
 *  
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *  
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 通过次数32,646提交次数48,670
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number429 {
	public List<List<Integer>> levelOrder(Node root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> result = new ArrayList<>();
		Deque<Node> deque = new ArrayDeque<>();
		deque.offer(root);
		while (!deque.isEmpty()) {
			int size = deque.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node node = deque.poll();
				temp.add(node.val);
				if (node.children != null && node.children.size() != 0) {
					for (Node childrenNode : node.children) {
						deque.offer(childrenNode);
					}
				}
			}
			result.add(temp);
		}
		return result;
	}
}
