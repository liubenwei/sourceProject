package com.liu.sourceProject.leetcode.number200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 * @Date 2020/12/3 13:12
 */
public class Number204 {
    public int countPrimes(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        if(n <= 1){
            return 0;
        }
        boolean[] bool = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(!bool[i]){
                count++;
                for(int j = i * 2; j < n; j += i){
                    bool[j] = true;
                }
            }
        }
        return count;
    }
}
