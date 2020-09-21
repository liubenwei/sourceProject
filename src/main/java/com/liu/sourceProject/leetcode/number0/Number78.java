package com.liu.sourceProject.leetcode.number0;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @Date 2020/9/21 19:06
 *
 *
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
[3],
[1],
[2],
[1,2,3],
[1,3],
[2,3],
[1,2],
[]
]
 */
public class Number78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i =0; i < nums.length; i++){
            int length = res.size();
            for(int j  =0; j < length; j++){
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
