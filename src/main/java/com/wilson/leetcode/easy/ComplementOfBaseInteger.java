package com.wilson.leetcode.easy;

/**
 * Created by i324291 on 2019/4/1.
 */
public class ComplementOfBaseInteger {
    public int bitwiseComplement(int num) {
        int temp = num;
        long i = 1;
        while (num != 0) {
            num >>= 1;
            i <<= 1;
        }
        return (int)(i - temp - 1);
    }

    public static void main(String[] args) {
        ComplementOfBaseInteger cobi = new ComplementOfBaseInteger();
        System.out.println(cobi.bitwiseComplement(105));
    }
}
