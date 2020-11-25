package com.liu.sourceProject.leetcode.number1300;

/**
 * @author liu
 * @Date 2020/11/25 17:54
 */
public class Number1370 {
    public String sortString(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[26];
        for(int i =0; i < s.length(); i++){
            nums[s.charAt(i) - 'a']++;
        }
        while(sb.length() < s.length()){
            for(int i =0 ; i< nums.length; i++){
                if(nums[i] > 0){
                    sb.append((char)(i+'a'));
                    nums[i]--;
                }
            }
            if(sb.length() < s.length()){
                for(int i =nums.length - 1 ; i >= 0; i--){
                    if(nums[i] > 0){
                        sb.append((char)(i+'a'));
                        nums[i]--;
                    }
                }
            }

        }
        return sb.toString();
    }
}
