package com.liu.sourceProject.leetcode.number100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//
//        找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//
//        示例:
//
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        运行你的函数后，矩阵变为：
//
//        X X X X
//        X X X X
//        X X X X
//        X O X X
//        解释:
//
//        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/surrounded-regions
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Number130 {

    public static void main(String[] args) {
        new ArrayList<>(Arrays.asList(new int[]{1}));
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        List<Integer> res = new ArrayList<>(9);
        System.out.println(res.size());
        int row = board.length, col = board[0].length;
        int i = 0, j = col - 1;
        while (i < col) {
            infect(board, 0, i);
            infect(board, row - 1, i);
            i++;
        }
        i = 0;
        while (i < row) {
            infect(board, i, 0);
            infect(board, i, col - 1);
            i++;
        }
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }

            }
        }
    }

    public void infect(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';
        infect(board, i + 1, j);
        infect(board, i - 1, j);
        infect(board, i, j + 1);
        infect(board, i, j - 1);
        return;
    }
}
