package com.liu.sourceProject.leetcode.number700;

import java.util.*;

/**
 * @author liu
 * @Date 2020/10/3 11:47
 */
public class Number771 {
    public static void main(String[] args) {
        new Number771().numJewelsInStones("asdf","asdf");
    }
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        Character[] characters = J.chars().mapToObj(c ->(char)c).toArray(Character[]::new);
        Set<Character> map = new HashSet<>(Arrays.asList(characters));
        char[] chars = S.toCharArray();
        for(char c: chars){
            if(map.contains(c)){
                res++;
            }
        }
        return  res;

    }
}
