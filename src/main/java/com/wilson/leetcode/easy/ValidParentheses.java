package com.wilson.leetcode.easy;

import java.util.Stack;

/**
 * Created by i324291 on 2019/3/17.
 */
public class ValidParentheses {
    public boolean isValid(String str) {
        if (str == null || str.length()%2 != 0) return false;
        final int len = str.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (isLeft(ch)) stack.push(ch);
            else {
                if (stack.isEmpty() || !isMatch(ch, stack.lastElement())) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isLeft(char ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }

    public boolean isMatch(char right, char left) {
        return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}');
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("([])"));
    }
}
