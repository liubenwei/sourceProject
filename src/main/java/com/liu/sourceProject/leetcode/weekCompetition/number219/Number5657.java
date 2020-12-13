package com.liu.sourceProject.leetcode.weekCompetition.number219;

/**
 * @author liu
 * @Date 2020/12/13 11:09
 */
public class Number5657 {
	public static void main(String[] args) {
		int[] stones = new int[] { 7,90,5,1,100,10,10,2 };
		new Number5657().stoneGameVII(stones);
	}

	public int stoneGameVII(int[] stones) {
		int Acount = 0, Bcount = 0, left = 0, right = stones.length - 1;
		int total = 0;
		total = getTotal(stones);
		while (left < right) {
			if (stones[left] > stones[right]) {
				Acount = Acount + total - stones[right];
				total = total - stones[right];
				right--;
			} else {
				Acount = Acount + total - stones[left];
				total = total - stones[left];
				left++;
			}
			if (left < right) {
				if (stones[left] > stones[right]) {
					Bcount = Bcount + total - stones[left];
					total = total - stones[left];
					left++;
				} else {
					Bcount = Bcount + total - stones[right];
					total = total - stones[right];
					right--;
				}
			}
		}
		System.out.println("Acount" + Acount);
		System.out.println("Bcount" + Bcount);
		return Acount - Bcount;
	}

	int getTotal(int[] stones) {
		int total = 0;
		for (int num : stones) {
			total += num;
		}
		return total;
	}
}
