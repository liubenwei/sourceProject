package com.liu.sourceProject.leetcode.number800;

import java.util.Queue;

/**
 * @author liu
 * @Date 2020/12/10 8:51
 */
public class Number860 {
    public static void main(String[] args) {
        boolean b = new Number860().lemonadeChange(new int[]{5,5,5,5,10,5,10,10,10,20});
        System.out.println(b);
    }
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for(int bill : bills){
            if(bill == 5){
                fiveCount++;
            }else if(bill == 10){
                if(fiveCount > 0){
                    fiveCount--;
                    tenCount++;
                }else{
                    return false;
                }
            }else {
                int temp = 15;
                while(temp > 10 && tenCount != 0){
                    temp -= 10;
                    tenCount--;
                }
                while(temp != 0 && fiveCount > 0){
                    temp -= 5;
                    fiveCount--;
                }
                if(temp != 0){
                    return false;
                }
            }
        }
        return true;
    }
}
