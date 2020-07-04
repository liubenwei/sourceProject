package com.liu.sourceProject.leetcode.number0;

//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
//
//        示例 1:
//
//        输入:
//        [
//          [1,1,1],
//          [1,0,1],
//          [1,1,1]
//        ]
//        输出:
//        [
//          [1,0,1],
//          [0,0,0],
//          [1,0,1]
//        ]
//        示例 2:
//
//        输入:
//        [
//          [0,1,2,0],
//          [3,4,5,2],
//          [1,3,1,5]
//        ]
//        输出:
//        [
//          [0,0,0,0],
//          [0,4,5,0],
//          [0,3,1,0]
//        ]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/set-matrix-zeroes
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Number73 {
    public void setZeroes(int[][] matrix) {
        Boolean colFlag = false, rowFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colFlag) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}
