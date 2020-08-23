package com.liu.sourceProject.leetcode.weekCompetition.Number203;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @Date 2020/8/23 10:49
 */
public class Number1 {
	public static void main(String[] args) {
		Number1 number1 = new Number1();
		int[] rounds = new int[] {
				2,1,2,1,2,1,2,1,2};
		int n = 2;
		List<Integer> list = number1.mostVisited(n, rounds);
		System.out.println(list);

	}

	public List<Integer> mostVisited(int n, int[] rounds) {
		int[] cicle = new int[n];
		int max = 0;
		for (int i = 0; i < rounds.length - 1; i++) {
			int j = i + 1;
			int current = rounds[i] - 1;
			if (i > 0) {
				cicle[current]--;
			}
			if(rounds[i+1] == n){
				while(current < n){
					cicle[current]++;
					max = Math.max(cicle[current], max);
					current = current+1;
				}
			}else{
				while (Math.abs(current - rounds[i+1]) != 0) {
					cicle[current]++;
					max = Math.max(cicle[current], max);
					current = (current + 1) % n;
				}
			}

		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < cicle.length; i++) {
			if (cicle[i] == max) {
				res.add(i + 1);
			}
		}
		return res;
	}
}
