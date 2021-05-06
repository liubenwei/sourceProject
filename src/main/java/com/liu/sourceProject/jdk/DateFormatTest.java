package com.liu.sourceProject.jdk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

    public static void main(String[] args) {
        String yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println(yyyyMMddHHmmss);
    }
}
