package com.liu.sourceProject.leetcode.number600;

import java.util.Queue;

/**
 * @author liu
 * @Date 2020/10/10 11:43
 */
public class Number678 {
    public static void main(String[] args) {

        System.out.println(new Number678().checkValidString("()"));
    }
    public boolean checkValidString(String s) {
        char[] charArray = s.toCharArray();
        int low = 0, high = 0;
        for(char c: charArray){
            if(c == '('){
                low++;
                high++;
            }else if(c == ')'){
                low = Math.max(low-1,0);
                high--;
                if(high < 0){
                    return false;
                }
            }else {
                low = Math.max(low -1,0);
                high++;
            }
        }
        return low <= 0;
    }
}
