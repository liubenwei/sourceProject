package com.liu.sourceProject.leetcode.offer;

public class Number58 {
    public static void main(String[] args) {
        Number58 number58 = new Number58();
//        String s = number58.reverseWords(" i am str.");
        String s = number58.reverseWords(" ");
        System.out.println("1"+s+"1");
    }
    public String reverseWords(String s) {
        char[] chars  =s.toCharArray();
        int left = 0, right = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = chars.length  -1; i >= 0; i--){
            while(i >=0 && chars[i] == ' '){
                i--;
            }
            right = i;
            while(i  >=0  && chars[i] != ' '){
                i--;
            }
            left = i;
            if(right >= 0){
                reverso(chars,left+1,right  ,stringBuilder);
            }

        }
        if(stringBuilder.length() > 0){

            return stringBuilder.deleteCharAt(stringBuilder.length() -1).toString();
        }
        return "";
    }
    public void reverso(char[] chars, int left, int right,StringBuilder stringBuilder){
        while(left <= right){
            if(chars[left] != ' '){
                stringBuilder.append(chars[left]);
            }

           left++;
        }
        stringBuilder.append(' ');
    }
}
