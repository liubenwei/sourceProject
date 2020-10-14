package com.liu.sourceProject.leetcode.number1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @Date 2020/10/14 8:29
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * 通过次数17,908提交次数25,590
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number1002 {
    public List<String> commonChars(String[] A) {
        List<String> list=  new ArrayList<>();
        int[] res = new int[26];
        for(char c : A[0].toCharArray()){
            res[c - 'a']++;
        }
        for(int i =1; i < A.length; i++){
            int[] temp = new int[26];
            for(char c : A[i].toCharArray()){
                temp[c - 'a']++;
            }
            for(int j =0 ; j < 26; j++){
                res[j] = Math.min(res[j],temp[j]);
            }
        }

        for(int i =0 ; i < 26; i++){
            if(res[i] > 0){
                for(int j =0 ; j < res[i]; j++){
                    list.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return list;
    }
}
