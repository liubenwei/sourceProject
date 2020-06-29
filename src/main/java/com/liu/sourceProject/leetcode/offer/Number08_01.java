package com.liu.sourceProject.leetcode.offer;

//三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
//
//        示例1:
//
//        输入：n = 3
//        输出：4
//        说明: 有四种走法
//        示例2:
//
//        输入：n = 5
//        输出：13
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

/**
 * @author liu
 */
public class Number08_01 {
    public int waysToStep(int n) {
        int a = 4, b = 2, c = 1;
        if(n <= 2){
            return n;
        }
        if(n == 3){
            return 4;
        }
        for(int i = 3; i < n; i++){
            int temp = a;
            a = ((b + c) % 1000000007 + a) % 1000000007 ;
            c = b;
            b = temp;
        }
        return a;
    }
}
