package com.liu.sourceProject.leetcode.number0;

/**
 * @author liu
 * @Date 2020/8/19 8:51 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 *        
 *
 *       示例 1:
 *
 *       输入: [1,2,0] 输出: 3 示例 2:
 *
 *       输入: [3,4,-1,1] 输出: 2 示例 3:
 *
 *       输入: [7,8,9,11,12] 输出: 1  
 *
 *       提示：
 *
 *       你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 *
 *       来源：力扣（LeetCode）
 *       链接：https://leetcode-cn.com/problems/first-missing-positive
 *       著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number41 {
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] >= 1 && nums[i] < nums.length
					&& nums[i] != nums[nums[i] - 1]) {
				swap(nums, i, nums[i] - 1);
			}
		}
		// System.out.println(nums[1]);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != (i + 1)) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

}
