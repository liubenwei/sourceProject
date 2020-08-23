package com.liu.sourceProject.leetcode.number1000;

/**
 * @author liu
 * @Date 2020/8/23 17:06
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 *
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 *
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 *
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * 所有行的大小都相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1020 {
    public int numEnclaves(int[][] A) {
        if(A == null || A.length == 0 || A[0].length == 0){
            return 0;
        }
        int rowLength = A.length;
        int colLength = A[0].length;
        int res = 0;
        for(int i =0; i < rowLength; i++){
            dfs(A,i,0);
            dfs(A,i,colLength - 1);
        }
        for(int i =0; i < colLength; i++){
            dfs(A,0,i);
            dfs(A,rowLength - 1,i);
        }
        for(int i =1 ; i < rowLength; i++){
            for(int j = 1; j < colLength; j++){
                if(A[i][j] == 1){
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int[][] A, int row, int col){
        if(row < 0 || col < 0 || row >= A.length || col >= A[0].length || A[row][col] != 1){
            return ;
        }
        A[row][col] = 0;
        dfs(A,row -1, col);
        dfs(A,row +1, col);
        dfs(A,row, col -1 );
        dfs(A,row, col + 1);
    }
}
