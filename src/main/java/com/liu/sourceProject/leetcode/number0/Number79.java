package com.liu.sourceProject.leetcode.number0;

/**
 * @author liu
 * @Date 2020/9/15 8:26
 */
public class Number79 {
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String word = "SEE";

		System.out.println(new Number79().exist(board,word));

	}

	public boolean exist(char[][] board, String word) {
		return bfs(board,word.toCharArray(),0,0,0);
	}

	private boolean bfs(char[][] board,char[] wordChars,int row, int col,int index){
	    if(row >= board.length || row < 0 || col > board[0].length || col < 0 || board[row][col] != wordChars[index]){
	        return false;
        }
	    if(index == wordChars.length - 1){
	        return  true;
        }else{
	        return bfs(board, wordChars, row + 1, col, index+1) ||
					bfs(board, wordChars, row -1 , col, index+1) ||
                    bfs(board, wordChars, row , col + 1, index+1) ||
					bfs(board, wordChars, row  , col - 1, index+1);
        }
    }
}
