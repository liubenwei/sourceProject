package com.liu.sourceProject.leetcode.number1200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liu
 * @Date 2020/10/14 14:21
 */
public class Number1249 {
    public static void main(String[] args) {
        String s = new Number1249().minRemoveToMakeValid2("lee(t(c)o)de)");
        System.out.println(s);
    }
    public String minRemoveToMakeValid(String s) {
        char[] charArray = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> errorIndex = new HashSet<>();
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == '('){
                deque.push(i);
            }else if(charArray[i] == ')'){
                if(deque.isEmpty()){
                    errorIndex.add(i);
                }else{
                    deque.pop();
                }
            }
        }
        while(!deque.isEmpty()){
            errorIndex.add(deque.pop());
        }
        StringBuilder sb = new StringBuilder("");
        System.out.println("size"+errorIndex.size());
        for(int i =0  ; i < charArray.length; i++){
            if(errorIndex.contains(i)){
                continue;
            }
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
    public String minRemoveToMakeValid2(String s) {
        char[] charArray = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> errorIndex = new HashSet<>();
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == '('){
                deque.push(i);
            }else if(charArray[i] == ')'){
                if(deque.isEmpty() || charArray[deque.peek()] != '('){
                    deque.push(i);
                }else{
                    deque.pop();
                }
            }
        }
        System.out.println(deque.size());
        StringBuilder sb = new StringBuilder("");
        for(int i =0  ; i < charArray.length; i++){
            if(!deque.isEmpty() &&  i == deque.peekLast()){
                deque.removeLast();
                continue;
            }
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}
