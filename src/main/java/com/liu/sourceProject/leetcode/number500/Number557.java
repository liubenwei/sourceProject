package com.liu.sourceProject.leetcode.number500;

import com.graphbuilder.curve.NURBSpline;

import javax.validation.constraints.NotNull;

/**
 * @author liu
 * @Date 2020/8/30 19:49
 */
public class Number557 {
    public static void main(String[] args) {
        Number557 number557 = new Number557();
        number557.reverseWords("Let's take LeetCode contest");
    }
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        int left=0, right = 0;
        while(right < chars.length){
            while(right < chars.length && chars[right] != ' '){
                right++;
            }
            swap(chars, left, right -1);
            left  = right+1;
            right++;
            System.out.println("chars:"+ new String(chars));
        }
        swap(chars,left, chars.length - 1);
        return new String(chars);
    }
    private void swap(char[] chars, int left, int right){
        while(left < right){
            char temp =  chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
