package com.wilson.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * ind the length of the longest valid (well-formed) parentheses substring.
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * Created by i324291 on 2019/3/17.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String str) {
        if (str == null || str.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> total = new HashMap<>();
        final int len = str.length();
        int maxLength = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '(') stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    int top = stack.peek();
                    total.put(i, total.getOrDefault(top - 1, 0) + (i - top) + 1);
                    maxLength = Math.max(maxLength, total.get(i));
                    stack.pop();
                }
            }
        }
        return maxLength;
    }

    public int longestValidParentheses1(String str) {
        if (str == null || str.length() == 0) return 0;
        final int len = str.length();
        int[] dp = new int[len];
        int max = 0;
        for (int i = 1; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '(') continue;
            else {
                int d = dp[i - 1] + 1;
                if ((i - d) >= 0 && str.charAt(i - d) == '(') {
                    dp[i] = dp[i-1] + 2;
                    if ((i - d - 1) >= 0) dp[i] += dp[i-d-1];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    private int longestValidParentheses2(String str) {
        if (str == null || str.length() == 0) return 0;
        final int len = str.length();
        int a = 0, b =0, count = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                a++;
                b++;
            } else {
                a--;
                b--;
            }
            a = Math.max(a, 0);
            if (b < 0) {
                count = 0;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
//        System.out.println(lvp.longestValidParentheses1("()"));
        System.out.println(lvp.longestValidParentheses2("()(()()()"));
//        System.out.println(lvp.longestValidParentheses("()"));
    }
}
