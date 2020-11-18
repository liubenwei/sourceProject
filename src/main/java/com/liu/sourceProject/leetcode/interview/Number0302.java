package com.liu.sourceProject.leetcode.interview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liu
 * @Date 2020/11/9 18:00
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number0302 {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();
    /** initialize your data structure here. */
    public Number0302() {

    }

    public void push(int x) {

    }

    public void pop() {

    }

    public int top() {
        return 0;
    }

    public int getMin() {
        return  0;
    }
}
