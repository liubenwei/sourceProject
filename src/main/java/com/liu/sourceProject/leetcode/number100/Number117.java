package com.liu.sourceProject.leetcode.number100;

import com.liu.sourceProject.leetcode.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author liu
 * @Date 2020/9/28 8:27
 *
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *  
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 *  
 *
 * 通过次数31,730提交次数60,179
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number117 {
    public Node connect(Node root) {
        root.next = null;
        return level(root);
    }
    public Node level(Node root){
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int length = queue.size();
            for(int i =0; i < length - 1; i++){
                Node node = queue.poll();
                node.next = queue.peek();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            Node node = queue.poll();
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            node.next = null;
        }
        return root;
    }

    public Node level2(Node root){
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int length = queue.size();
            while(length-- > 0){
                Node node = queue.poll();
                if(length > 0){
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

        }
        return root;
    }
}
