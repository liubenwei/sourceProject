package com.liu.sourceProject.leetcode.number300;

import java.util.*;

/**
 * @author liu
 * @Date 2020/8/20 20:54
 *     public List<Integer> countSmaller(int[] nums) {
 *         if(nums == null || nums.length == 0){
 *             return new ArrayList<>();
 *         }
 *         Stack<Integer> stack = new Stack<>();
 *         int length = nums.length;
 *         int[] result = new int[length];
 *         for(int i = nums.length - 1; i >= 0; i--){
 *             if(stack.isEmpty()){
 *                 result[i] = 0;
 *                 stack.push(nums[i]);
 *                 continue;
 *             }else if(nums[i] > stack.peek()){
 *                 result[i] = stack.size();
 *                 stack.push(nums[i]);
 *                 continue;
 *             }
 *             while(!stack.isEmpty() && nums[i] <= stack.peek()){
 *                 stack.pop();
 *             }
 *             result[i] = stack.size();
 *             stack.push(nums[i]);
 *         }
 *         List<Integer> res = new ArrayList<>();
 *         for(int i =0 ; i < result.length; i++){
 *             res.add(result[i]);
 *         }
 *         return res;
 *      //   return new ArrayList<Integer>(Arrays.asList(result));
 *     }
 */
public class Number315 {
	public static void main(String[] args) {
		Number315 number315 = new Number315();
		int[] nums = new int[]{5,2,6,1};
		List<Integer> list = number315.countSmaller(nums);
		System.out.println(list);

	}

	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		Integer[] res = new Integer[nums.length];

		// 栈里存放数组下标
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			int temp = 0;
			while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
				res[stack.pop()] = temp;
				temp++;
			}
			stack.push(i);
		}
		return new ArrayList<>(Arrays.asList(res));

	}
}
