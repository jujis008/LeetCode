package com.wilson.leetcode.easy;

import java.util.UUID;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123
 * Output: 321
 * Example 2:
 * 
 * Input: -123
 * Output: -321
 * Example 3:
 * 
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * Created by i324291 on 2018/5/23.
 */
public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;
        try {
            boolean neg = (x < 0);
            String s = String.valueOf(neg ? -x : x);
            StringBuilder builder = new StringBuilder(s);
            int pv = Integer.parseInt(builder.reverse().toString());
            return neg ? -pv : pv;
        } catch (Exception e) {
            return 0;
        }
    }

    public int reverse2(int x) {
        int ans = 0, res = x, cur = 0;
        while (res != 0) {
            cur = res % 10;
            res = res / 10;
            ans = ans * 10 + cur;
//            System.out.println("cur= " + cur + ", res= " + res + ", ans= " + ans);
        }
//        System.out.println(ans % 10);
        ans = ans % 10 == cur ? ans : 0;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().length());
        System.out.println(new ReverseInteger().reverse2(123));
        System.out.println(new ReverseInteger().reverse2(-123));
        System.out.println(new ReverseInteger().reverse2(-120));
        System.out.println(new ReverseInteger().reverse2(1534236469));
    }
}
