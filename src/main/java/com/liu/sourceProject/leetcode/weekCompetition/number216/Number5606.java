package com.liu.sourceProject.leetcode.weekCompetition.number216;

/**
 * @author liu
 * @date 2020/11/22 11:01
 * 27
 * 3
 * 24
 *
 * 73
 * 5
 * 68
 * 25+25 +18
 */
public class Number5606 {
    public String getSmallestString(int n, int k) {

        StringBuilder res = new StringBuilder();
        int currentLength = 0;
        int aCount  = 0, notACount = 0, count = 0,zCount = 0;
        notACount = k - n;
        while(notACount > 25){
            zCount++;
            notACount = notACount - 25;
        }
        if(notACount != 0){
            aCount = n - zCount - 1;
            while(aCount != 0){
                res.append('a');
                aCount--;
            }
            res.append(notACount+'a');
            while(zCount!= 0){
                res.append('z');
                zCount--;
            }
        }else{
            aCount = n - zCount;
            while(aCount != 0){
                res.append('a');
                aCount--;
            }
            res.append((char)(notACount+'a'));
            while(zCount!= 0){
                res.append('z');
                zCount--;
            }
        }
        return res.toString();
    }
}
