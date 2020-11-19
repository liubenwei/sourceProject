package com.liu.sourceProject.leetcode.number200;

/**
 * @author liu
 * @Date 2020/11/19 9:19
 */
public class Number283 {
    public void moveZeroes(int[] nums) {
        int left =0, right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
                right++;
            }else{
                right++;
            }
        }
        while(left < nums.length){
            nums[left++] = 0;
        }
    }
}
