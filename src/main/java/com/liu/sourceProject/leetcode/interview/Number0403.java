package com.liu.sourceProject.leetcode.interview;

import com.liu.sourceProject.leetcode.ListNode;
import com.liu.sourceProject.leetcode.TreeNode;
import org.omg.CORBA.TRANSACTION_MODE;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author liu
 * @Date 2020/10/13 11:12
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * 通过次数10,178提交次数12,659
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number0403 {

    public ListNode[] listOfDepth(TreeNode tree) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<ListNode> res = new ArrayList<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            int size = queue.size();
            ListNode pre = new ListNode(0);
            ListNode head = pre;
            for(int i = 0; i < size; i++){
                TreeNode treeNode = queue.poll();
                ListNode listNode = new ListNode(treeNode.val);
                pre.next = listNode;
                pre = pre.next;

                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            res.add(head.next);
        }
        ListNode[] listNodes = new ListNode[res.size()];
        res.toArray(listNodes);
        return listNodes;
    }
}
