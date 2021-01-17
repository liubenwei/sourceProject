package com.liu.sourceProject.leetcode.number1200;

/**
 * @author liu
 * @Date 2021/1/17 12:18
 */
public class Number1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates == null || coordinates.length == 0 || coordinates[0].length == 0){
            return true;
        }

        for(int i = 2; i < coordinates.length; i++){
            if( (coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0]) != (coordinates[i][1] - coordinates[0][1]) * (coordinates[1][0] - coordinates[0][0])){
                return false;
            }
        }
        return true;
    }
}
