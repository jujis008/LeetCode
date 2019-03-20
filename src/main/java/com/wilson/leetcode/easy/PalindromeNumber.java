package com.wilson.leetcode.easy;

/**
 * Created by i324291 on 2019/3/7.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        final String s = Integer.toString(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(-1001));
    }
}
