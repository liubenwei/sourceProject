package com.liu.sourceProject.leetcode.offer;

public class Number11 {
    public static void main(String[] args) {
        int[] ar = new int[]{2,2,2,0,1};
        int i = minArray(ar);
        System.out.println(i);
    }
    public static int minArray(int[] numbers) {
        if(numbers.length == 1){
            return numbers[0];
        }
        int n =  numbers.length - 1;
        while(n > 0 && numbers[n] == numbers[0]){
            n--;
        }
        if(numbers[n] >= numbers[0]){
            return numbers[0];
        }
        int l = 0, r = n;
        while(l <= n){
            int mid = l + (r - l) /2;
            if(numbers[mid] <  numbers[0]){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return numbers[r +1];
    }
}
