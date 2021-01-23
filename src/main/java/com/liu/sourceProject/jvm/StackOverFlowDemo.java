package com.liu.sourceProject.jvm;

/**
 * @author liu
 * @Date 2021/1/23 13:15
 *
 *       不加任何参数 执行结果 current n :9155
 *       current n :9156
 *       current n :9157
 *       current n :9158
 *       current n :9159
 *       Exception in thread "Thread-0"
 *       java.lang.StackOverflowError
 *
 *       加入参数 -Xss256K 返回结果
 *       current n :2095
 *       current n :2096
 *      current n :2097
 *      current n :2098
 *      Exception in thread "Thread-0" java.lang.StackOverflowError
 *
 *      win10 x86_64最小栈的大小为108K
 */
public class StackOverFlowDemo {
	public static void main(String[] args) {
		new Thread(() -> add(1)).start();

	}

	public static int add(int n) {
		System.out.println("current n :" + n);
		return add(n + 1);
	}
}
