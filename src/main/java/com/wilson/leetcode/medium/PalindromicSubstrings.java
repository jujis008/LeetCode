package com.wilson.leetcode.medium;

/**
 * Created by i324291 on 2019/3/7.
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        final char[] strs = preHandle(s).toCharArray();
        final int len = strs.length;
        int mid = 0, right = 0, count = 0;
        int[] c = new int[len];
        for (int i = 1; i < len - 1; ++i) {
            int left = 2 * mid - i;
            c[i] = right > i ? Math.min(right - i, c[left]) : 0;
            while (strs[i + c[i] + 1] == strs[i - c[i] - 1]) c[i]++;
            if (i + c[i] > right) {
                right = i + c[i];
                mid = i;
            }
        }
        for (int cc : c) {
            count += (cc + 1) / 2;
        }
        return count;
    }
    private String preHandle(String src) {
        char[] srcs = src.toCharArray();
        StringBuilder sb = new StringBuilder("@#");
        for (char c : srcs) {
            sb.append(c);
            sb.append("#");
        }
        sb.append("$");
        return sb.toString();
    }

    public static void main(String[] args) {
        PalindromicSubstrings ps = new PalindromicSubstrings();
        System.out.println(ps.countSubstrings("abc"));
    }
}
