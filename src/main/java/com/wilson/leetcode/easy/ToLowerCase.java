package com.wilson.leetcode.easy;

/**
 * Created by i324291 on 2019/3/17.
 */
public class ToLowerCase {
    public String toLowerCase(String str) {
        if (str == null || str.length() ==0) return str;
        final int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) > 64 && str.charAt(i) < 91) {
                sb.append((char)(str.charAt(i) + 32));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ToLowerCase tlc = new ToLowerCase();
        System.out.println(tlc.toLowerCase("ZHello"));
    }
}
