package com.wilson.leetcode.medium;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * 
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 * Created by i324291 on 2018/5/23.
 */
public class StringToInteger {

    public int myAtoi(String str) {
        if (null == str || str.isEmpty()) return 0;
        int res = 0, cur;
        boolean negative = false;
        char firstChar = str.charAt(0);
        int len = str.length();
        if (len > 1) {
            for (int i = 1; i < len; i++) {
                if (firstChar == 32) {
                    firstChar = str.charAt(i);
                    continue;
                }
                negative = firstChar == '-';
                boolean sign = (firstChar == '-' || firstChar == '+');
                char thisChar =  sign ? str.charAt(i) : str.charAt(i - 1);
                if (thisChar > 47 && thisChar < 58) {
                    cur = (thisChar - 48);
                    res = res * 10 + cur;
                    thisChar = str.charAt(i);
                    if (i == len - 1 && thisChar > 47 && thisChar < 58 && ! sign) {
                        cur = (thisChar - 48);
                        res = res * 10 + cur;
                    }
                } else {
                    break;
                }
                if (res % 10 != cur) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
        } else if (firstChar > 47 && firstChar < 58) {
            cur = (firstChar - 48);
            res = res * 10 + cur;
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        //"+-2"，"+"，"-9223372036854775809"
//        System.out.println(new StringToInteger().myAtoii("4193 with words"));
//        System.out.println(new StringToInteger().myAtoii("+-2"));
//        System.out.println(new StringToInteger().myAtoii("+"));
//        System.out.println(new StringToInteger().myAtoii("2"));
//        System.out.println(new StringToInteger().myAtoii("-9223372036854775809"));
        System.out.println(new StringToInteger().myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
//        System.out.println(new StringToInteger().myAtoi("   42"));
//        System.out.println(new StringToInteger().myAtoi("words and 987"));
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println((int)'-'); //48-57 +43 -45
    }
}
