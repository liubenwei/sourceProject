package com.liu.sourceProject.leetcode.number1600;

/**
 * @author liu
 * @Date 2020/12/9 14:31
 */
public class Number1680 {
	public static void main(String[] args) {
		int i = new Number1680().concatenatedBinary(5);
		System.out.println(i);
	}

	public int concatenatedBinary(int n) {
		int mod = (int) 1e9 + 7;
		long ans = 0;
		for (int i = 1; i <= n; i++) {
			int len = Integer.toBinaryString(i).length();
			ans = (ans << len) % mod;
			ans = (ans + i) % mod;
		}
		return (int) (ans % mod);
	}
}
