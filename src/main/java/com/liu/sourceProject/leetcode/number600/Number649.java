package com.liu.sourceProject.leetcode.number600;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author liu
 * @Date 2020/12/11 10:39
 */
public class Number649 {
	public String predictPartyVictory(String senate) {
		Deque<Integer> rad = new ArrayDeque<>();
		Deque<Integer> dire = new ArrayDeque<>();
		int length = senate.length();
		for (int i = 0; i < senate.length(); i++) {
			char c = senate.charAt(i);
			if (c == 'R') {
				rad.offer(i);
			} else if (c == 'D') {
				dire.offer(i);
			}
		}
		while (!rad.isEmpty() && !dire.isEmpty()) {
			int r = rad.remove();
			int d = dire.remove();
			if (r < d) {
				rad.offer(r + length);
			} else {
				dire.offer(d + length);
			}
		}
		return rad.isEmpty() ? "Dire" : "Radiant";
	}
}
