package com.liu.sourceProject.leetcode.number300;

/**
 * @author liu
 * @Date 2020/10/9 9:49
 */
public class Number344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
