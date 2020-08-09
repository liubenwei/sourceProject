package com.liu.sourceProject.jdk;

import javafx.beans.binding.StringBinding;

/**
 * @author liu
 * @Date 2020/8/9 11:15
 */
public class StringBuilderTest {
    public static void main(String[] args) {
//        0111001
//        StringBuilder stringBuilder = new StringBuilder("1011");
//        System.out.println(stringBuilder);
//        int length = stringBuilder.length();
//        for(int i = 0; i < length; i++ ){
//            System.out.println("length:"+stringBuilder.length() +" string :"+stringBuilder);
//            System.out.println("index:"+i+" char:"+stringBuilder.charAt(i));
//            if(stringBuilder.charAt(i) == '1'){
//                stringBuilder.replace(i,i+1,"0");
//            }else{
//                stringBuilder.replace(i,i+1,"1");
//            }
//            if(i > 100){
//                break;
//            }
//        }
//        System.out.println(stringBuilder);
        StringBuilderTest test = new StringBuilderTest();
        test.findKthBit(20,1000000);
    }


    public StringBuilder invert(StringBuilder sb){
        int length = sb.length();
        for(int i = 0; i < length; i++ ){
            if(sb.charAt(i) == '1'){
                sb.replace(i,i+1,"0");
            }else{
                sb.replace(i,i+1,"1");
            }
        }
//         System.out.println("sb:"+sb);
        return sb;
    }

    public char findKthBit(int n, int k) {
        StringBuilder sb =  new StringBuilder("0");
        // StringBuilder s1 = solve(sb,n);
        // System.out.println("s1:"+s1);
        // return s1.charAt(k-1);
        StringBuilder last;
        for(int i = 0 ; i < n - 1; i++){
            last = sb;
            sb = new StringBuilder().append(last).append("1").append(invert(last).reverse());
            System.out.println("current length :"+sb.length());
            if(sb.length() > k){
                System.out.println("length:"+sb.length());
                return sb.charAt(k - 1);
            }
        }
        System.out.println();
        System.out.println("length:"+sb.length());
//        System.out.println("sb:"+sb);
        return sb.charAt(k-1);
    }
}
