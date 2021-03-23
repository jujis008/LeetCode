package com.wilson.leetcode.easy;

import org.omg.PortableServer.POA;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * Accepted
 * 801,707 Submissions 1,895,948
 */
public class PlusOne {

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[digits.length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public int[] plusOne(int[] digits) {
        final int len = digits.length;
        int flag;
        int i = len - 1;
        if (digits[i] + 1 > 9) {
            digits[i--] = 0;
            flag = 1;
        } else {
            digits[i] += 1;
            return digits;
        }
        while(i >= 0) {
            if (digits[i] + flag > 9) {
                digits[i--] = 0;
                flag = 1;
            } else {
                digits[i] += 1;
                flag = 0;
                break;
            }
        }
        if (flag == 1) {
            int[] newDigits = new int[len + 1];
            newDigits[0] = 1;
            System.arraycopy(digits, 0, newDigits, 1, len);
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] args) {
//        int[] digits = {1,2,3};
        int[] digits = {8, 9, 9};
//        int[] digits = {8, 9, 9 , 9};
        PlusOne po = new PlusOne();
        for (int val : po.plusOne2(digits)) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
