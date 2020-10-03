package com.liu.sourceProject.leetcode.number0;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 * @Date 2020/10/3 12:26
 */
public class Number1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
