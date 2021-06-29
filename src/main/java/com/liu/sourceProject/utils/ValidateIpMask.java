package com.liu.sourceProject.utils;

public class ValidateIpMask {
    //判断ip是否在某个网段
    public static boolean validate(String ip, String ipMask) {
        String[] ipSegment = ip.split("\\.");
        int res = 0;
        for (String s : ipSegment) {
            int i = Integer.parseInt(s);
            res = res * 128 + i;
        }
        int i = IPv4Util.ipToInt("127.0.0.1");
        System.out.println(i);
        return true;
    }

    public static void main(String[] args) {
        validate("127.0.0.1", "1982");
    }
}
