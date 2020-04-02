package com.wilson.leetcode.medium;

/**
 * Created by i324291 on 2019/3/17.
 */
public class ShiftingLetters {
    public String shiftingLetters(String str, int[] shifts) {
        if (str == null || str.length() == 0)return str;
        final int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = shifts.length - 1; i > 0; i--) {
            shifts[i] %= 26;
            shifts[i-1] += shifts[i];
        }
        for (int i = 0; i < len; i++) {
            if (i >= shifts.length) {
                sb.append(str.substring(i));
                break;
            }
            int shifted = (str.charAt(i) + shifts[i] % 26);
            sb.append((char)(shifted > 122 ? (shifted - 26) : shifted));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "mkgfzkkuxownxvfvxasy";
        int[] shifts = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        System.out.println(str.length());
        System.out.println(shifts.length);
        ShiftingLetters sl = new ShiftingLetters();
        System.out.println(sl.shiftingLetters(str, shifts));
    }
}
