package com.liu.sourceProject.leetcode.number1200;

/**
 * @author liu
 * @Date 2020/10/14 14:37
 */
public class Number1248 {
    public static void main(String[] args) {
        int i = new Number1248().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
        System.out.println(i);
    }
    public int numberOfSubarrays(int[] nums, int k) {
        if(k == 0){
            return 0;
        }
        int count = 0,left = 0,right = 0;
        int res = 0;
        while(right < nums.length && count < k){
            if( (nums[right] & 1) == 1){
                count++;
            }
            right++;
        }
        if(count < k){
            return 0;
        }
        res++;
        while(right < nums.length){
            while (left < right &&  (nums[left] & 1) != 1 ){
                res++;
                left++;
            }
            left++;
            count--;
            right--;
            while(right < nums.length && count < k){
                if( (nums[right] & 1) == 1){
                    count++;
                }
                right++;

            }
            if(count == k){
                res++;
            }else{
                break;
            }
        }
        return res;
    }
}
