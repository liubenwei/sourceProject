//
//给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
//
//        一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
//
//        返回一对观光景点能取得的最高分。
//
//         
//
//        示例：
//
//        输入：[8,1,5,2,6]
//        输出：11
//        解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/search-a-2d-matrix

// 根据题意， res = A[i]+i + a[j]-j
// 既最大值为: (j左边最大的A[i]+i) + (当前位置j的 A[j] - j)
//所以需要把max(A[i] + i)保存起来 、代码如下：
package com.liu.sourceProject.leetcode.number1000;
public class Number1014 {
    public int maxScoreSightseeingPair(int[] A) {

        int res = Integer.MIN_VALUE;
        int left = A[0];//当i=0时 A[i] + i = A[i]
        for(int j = 0; j < A.length; j++){
            res = Math.max(res, left + A[j] - j);
            left = Math.max(left, A[j]+j);
        }
        return res;
    }
}
