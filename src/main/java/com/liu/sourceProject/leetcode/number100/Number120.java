package com.liu.sourceProject.leetcode.number100;

import java.util.List;


//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
//        相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//         
//
//        例如，给定三角形：
//
//        [
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//        自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/triangle
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Number120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                res[j] = Math.min(res[j], res[j+1])+triangle.get(i).get(j);
            }
        }
        return res[0];
    }
}
