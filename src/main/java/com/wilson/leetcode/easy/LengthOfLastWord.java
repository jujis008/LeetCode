package com.wilson.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 * Created by i324291 on 2018/1/16.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
//        return s.trim().length() - s.trim().lastIndexOf(" ")-1;
        int len = s.length();
        int lastLength = 0;
        while (len > 0 && s.charAt(len - 1) == ' ') {
            len --;
        }

        while (len > 0 && s.charAt(len - 1) != ' ') {
            lastLength ++;
            len --;
        }
        return lastLength;
    }

    public static void main(String[] args) {
        LengthOfLastWord length = new LengthOfLastWord();
        System.out.println("Hello world ".trim());
        System.out.println(length.lengthOfLastWord("Hello world."));
    }
}
