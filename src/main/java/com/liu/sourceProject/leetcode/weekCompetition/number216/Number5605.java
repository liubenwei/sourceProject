package com.liu.sourceProject.leetcode.weekCompetition.number216;

/**
 * @author liu
 * @date 2020/11/22 11:22
 */
public class Number5605 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        //Arrays.sort(word1);
        //Arrays.sort(word2);
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for(String string: word1){
            sb1.append(string);
        }
        for(String string: word2){
            sb2.append(string);
        }

        return sb1.toString().equals(sb2.toString());
    }
}
