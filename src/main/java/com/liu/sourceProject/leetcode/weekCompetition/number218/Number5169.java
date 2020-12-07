package com.liu.sourceProject.leetcode.weekCompetition.number218;

/**
 * @author liu
 * @Date 2020/12/6 11:06
 */
public class Number5169 {
	public static void main(String[] args) {
		Number5169 number5169 = new Number5169();
		number5169.concatenatedBinary(12);
//		System.out.println(Integer.toHexString(23));
//		System.out.println(Integer.toHexString(16));
//		System.out.println(Integer.toBinaryString(1000000007).length());

	}

	public int concatenatedBinary(int n) {
		StringBuilder sb = new StringBuilder();
		Long temp;
		int res;
		for (int i = 1; i <= n; i++) {
			sb.append(Integer.toBinaryString(i));
		}
		System.out.println(sb.toString());

//		temp = Long.valueOf(sb.toString(),2) % 1000000007;
//		System.out.println(temp);

		while(sb.length() > 30){
			sb.deleteCharAt(0);
		}
		System.out.println(sb.toString());
		temp = Long.valueOf(sb.toString(),2);
		temp= temp & 1000000006;
		System.out.println(temp);
		return 0;
	}
}
