package com.liu.sourceProject.leetcode.number900;

/**
 * @author liu
 * @Date 2020/11/12 18:55
 */
public class Number922 {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for(int i =0 ; i < A.length - 1; i = i+2){
            if( (A[i] & 1) != 0){
                while( (A[j] & 1) != 0){
                    j = j + 2;
                }
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }
}
