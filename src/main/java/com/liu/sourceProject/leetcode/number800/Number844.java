package com.liu.sourceProject.leetcode.number800;

/**
 * @author liu
 * @Date 2020/10/19 8:24
 */
public class Number844 {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sStrignBuilder = new StringBuilder();
        StringBuilder tStrignBuilder = new StringBuilder();
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        for (char c : sChars) {
            if (c == '#') {
                if (sStrignBuilder.length() != 0) {
                    sStrignBuilder.deleteCharAt(sStrignBuilder.length() - 1);
                }
            } else {
                sStrignBuilder.append(c);
            }
        }

        for (char c : tChars) {
            if (c == '#') {
                if (tStrignBuilder.length() != 0) {
                    tStrignBuilder.deleteCharAt(tStrignBuilder.length() - 1);
                }
            } else {
                tStrignBuilder.append(c);
            }
        }

        return sStrignBuilder.toString().equals(tStrignBuilder.toString());
    }
}
