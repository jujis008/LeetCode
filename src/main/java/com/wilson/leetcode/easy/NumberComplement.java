package com.wilson.leetcode.easy;

/**
 * Created by i324291 on 2019/4/1.
 */
public class NumberComplement {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        String nBin = Integer.toBinaryString(~num);
        return Integer.parseInt(nBin.substring(nBin.length() - bin.length()), 2);
    }

    public static void main(String[] args) {
        NumberComplement nc = new NumberComplement();
        System.out.println(nc.findComplement(105));
    }
}
