package com.wilson.leetcode.hard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Special binary strings are binary strings with the following two properties:
 * The number of 0's is equal to the number of 1's.
 * Every prefix of the binary string has at least as many 1's as 0's.
 * Given a special string S, a move consists of choosing two consecutive, non-empty,
 * special substrings of S, and swapping them. (Two strings are consecutive
 * if the last character of the first string is exactly one index before the first character of the second string.)
 * At the end of any number of moves, what is the lexicographically largest resulting string possible?
 *
 * Example 1:
 * Input: S = "11011000"
 * Output: "11100100"
 * Explanation:
 * The strings "10" [occuring at S[1]] and "1100" [at S[3]] are swapped.
 * This is the lexicographically largest string possible after some number of swaps.
 * Note:
 *
 * S has length at most 50.
 * S is guaranteed to be a special binary string as defined above.
 * Created by i324291 on 2019/3/19.
 */
public class SpecialBinaryString {
    public String makeLargestSpecial(String str) {
        if (str == null || str.length() == 0) return str;
        final int len = str.length();
        int count = 0, distant = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '1') count++;
            else count--;
            if (count == 0) {
                res.add("1" + makeLargestSpecial(str.substring(distant + 1, i)) + "0");
                distant = i + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);
    }

    public static void main(String[] args) {
        SpecialBinaryString pbs = new SpecialBinaryString();
        System.out.println(pbs.makeLargestSpecial("11011000"));
    }
}
