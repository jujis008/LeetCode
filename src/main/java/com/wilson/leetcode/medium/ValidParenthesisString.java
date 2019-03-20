package com.wilson.leetcode.medium;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the validity of a string by these rules:
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 * Created by i324291 on 2019/3/19.
 */
public class ValidParenthesisString {
    public boolean checkValidString(String str) {
        if (str == null || str.length() == 0) return true;
        final int len = str.length();
        int a = 0, b = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                a++;
                b++;
            } else if (ch == ')') {
                a--;
                b--;
            } else {
                a--;
                b++;
            }
            a = Math.max(0, a);
            if (b < 0) return false;
        }
        return a == 0;
    }

    public static void main(String[] args) {
        ValidParenthesisString vps = new ValidParenthesisString();
        System.out.println(vps.checkValidString(")(((()))"));
    }
}
