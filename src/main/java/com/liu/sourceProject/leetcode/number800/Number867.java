package com.liu.sourceProject.leetcode.number800;

/**
 * @author liu
 * @Date 2021/2/25 11:51
 */
public class Number867 {
    public int[][] transpose(int[][] matrix) {

        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return matrix;
        }
        int[][] res = new int[matrix[0].length][matrix.length];

        for(int j = 0; j < matrix[0].length; j++){
            for(int i= 0; i < matrix.length; i++){
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
}
