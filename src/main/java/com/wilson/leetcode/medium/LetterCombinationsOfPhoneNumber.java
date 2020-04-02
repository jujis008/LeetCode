package com.wilson.leetcode.medium;

import java.util.*;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * Created by i324291 on 2019/3/25.
 */
public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() < 1) return result;
        Map<Integer, String> map = new HashMap<>();
        String[] dict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < 9; i++) {
            map.put(i + 1, dict[i]);
        }
        System.out.println(map.get(1));
        dfs(digits, 0, 0, map, new StringBuilder(), result);
        return result;
    }

    private void dfs(String digits, int index, int cur, Map<Integer, String> map, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        String curStr = map.get(Integer.parseInt(digit + ""));
        if (curStr != null) {
            for (int i = cur; i < curStr.length(); i++) {
                sb.append(curStr.charAt(i));
                dfs(digits, index + 1, 0, map, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber lcopn = new LetterCombinationsOfPhoneNumber();
        System.out.println(lcopn.letterCombinations(""));
    }
}
