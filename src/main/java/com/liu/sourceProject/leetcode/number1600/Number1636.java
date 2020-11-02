package com.liu.sourceProject.leetcode.number1600;

/**
 * @author liu
 * @Date 2020/11/2 8:21
 */
public class Number1636 {
    public int countVowelStrings(int n) {
        return (n + 4) * (n + 3) * (n + 2) * (n+1)/24;
    }
}
