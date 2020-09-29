package com.liu.sourceProject.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liu
 * @Date 2020/9/3 19:50
 */
public class IdCardTest {
    public static void main(String[] args) {
        System.out.println("中共问");
        String reges = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\s\\S]{8,16}$";
        Pattern passwordPattern = Pattern.compile(reges);
        Matcher matcher = passwordPattern.matcher("iiuie01?");
        System.out.println(matcher.matches());

//        String regex=  "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
//        "362425199807230450".matches(regex);
//        System.out.println("360430199603200322".matches(regex));
    }
}
