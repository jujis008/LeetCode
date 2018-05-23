package com.wilson.leetcode.medium;

/**
 * Created by i324291 on 2017/11/27.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P[A]]Y[P/A[L]]I[S/H[I]]R[I/N[G 2*(n-1) = 4
 * P   A   H   N
 * A  P L S I I G
 * Y    I    R
 *
 * PAYPALISHIRING
 * P    I   N
 * A  L S  I G
 * Y A  H R
 * P    I
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(final String s, int numRows) {
        char[] chs = s.toCharArray();
        final int len = chs.length;
        StringBuilder[] builders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            builders[i] = new StringBuilder();
        }

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                builders[idx].append(chs[i++]);
            }
            for (int idx = numRows-2; idx > 0 && i < len; idx--) {
                builders[idx].append(chs[i++]);
            }
        }
        for (int idx = 1; idx < numRows; idx++) {
            builders[0].append(builders[idx]);
        }
        return builders[0].toString();
    }


    public static void main(String[] args) {
        ZigZagConversion zig = new ZigZagConversion();
        System.out.println(zig.convert("PAYPALISHIRING", 4));
    }

}
