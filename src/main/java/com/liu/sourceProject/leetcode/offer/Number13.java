package com.liu.sourceProject.leetcode.offer;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//         
//
//        示例 1：
//
//        输入：m = 2, n = 3, k = 1
//        输出：3
//        示例 2：
//
//        输入：m = 3, n = 1, k = 0
//        输出：1
//        提示：
//
//        1 <= n,m <= 100
//        0 <= k <= 20
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Number13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return infect(m ,n, 0 ,0 ,k, visited);
    }

    public int infect(int totalRow, int totalCol, int currentRow, int currentCol, int k,boolean[][] visited){
        if(currentRow >= totalRow || currentCol >= totalCol || visited[currentRow][currentCol]|| (currentRow/10 + currentRow %10 + currentCol /10 + currentCol%10) > k){
            return 0;
        }
        visited[currentRow][currentCol] = true;
        return infect(totalRow,totalCol,currentRow+1,currentCol,k,visited) +
                infect(totalRow,totalCol,currentRow,currentCol+1,k,visited) + 1;
    }
}
