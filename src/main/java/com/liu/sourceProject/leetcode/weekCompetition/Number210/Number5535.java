package com.liu.sourceProject.leetcode.weekCompetition.Number210;

/**
 * @author liu
 * @Date 2020/10/11 10:57
 */
public class Number5535 {
    public int maxDepth(String s) {
        int depth = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(c == '('){
                depth++;
                max = Math.max(max,depth);
            }else if(c == ')'){
                depth--;
            }
        }
        return max;
    }
}
