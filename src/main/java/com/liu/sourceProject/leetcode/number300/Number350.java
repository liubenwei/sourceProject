package com.liu.sourceProject.leetcode.number300;

import java.util.ArrayList;
import java.util.Arrays;

//给定两个数组，编写一个函数来计算它们的交集。
//
//         
//
//        示例 1：
//
//        输入：nums1 = [1,2,2,1], nums2 = [2,2]
//        输出：[2,2]
//        示例 2:
//
//        输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        输出：[4,9]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Number350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2 == null || nums1 == null || nums1.length == 0 || nums2.length == 0){
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < nums1.length;){
            if(j < nums2.length && nums1[i] < nums2[j]){
                i++;
            }else if(j < nums2.length && nums1[i] > nums2[j]){
                j++;
            }else if(j < nums2.length && nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }else{
                break;
            }
        }
        int[] result = new int[res.size()];
        for(int i =0 ; i < result.length; i++){
            result[i] = res.get(i);
        }
        return result;

    }
}
