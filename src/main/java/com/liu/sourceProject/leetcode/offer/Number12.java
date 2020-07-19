package com.liu.sourceProject.leetcode.offer;
//
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
//
//        [["a","b","c","e"],
//        ["s","f","c","s"],
//        ["a","d","e","e"]]
//
//        但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
//
//         
//
//        示例 1：
//
//        输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//        输出：true
//        示例 2：
//
//        输入：board = [["a","b"],["c","d"]], word = "abcd"
//        输出：false
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class Number12 {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0){
            return false;
        }
        char[] wordArray = word.toCharArray();
        int rowLength = board.length;
        int colLength = board[0].length;
        boolean[][] isVisited = new boolean[rowLength][colLength];
        for(int i = 0; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(search(board,i,j,0,wordArray,isVisited)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(char[][] board, int i, int j,int index,char[] wordArray,boolean[][] isVisited){
        if(index == wordArray.length){
            return true;
        }
        if(i < 0 || j < 0 ||i >= board.length || j >= board[0].length || isVisited[i][j] == true || board[i][j] != wordArray[index]){
            return false;
        }
        isVisited[i][j] = true;
        boolean res = search(board, i+1,j,index+1,wordArray,isVisited) || search(board,i-1,j,index+1,wordArray,isVisited) || search(board,i,j+1,index+1,wordArray,isVisited) || search(board,i,j-1,index+1,wordArray,isVisited);
        isVisited[i][j] = false;
        return res;
    }
}
