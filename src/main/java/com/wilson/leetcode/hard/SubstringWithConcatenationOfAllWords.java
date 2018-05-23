package com.wilson.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 *
 * You should return the indices: [0,9].
 * (order does not matter).
 *
 * Created by i324291 on 2018/1/16.
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indecis = new ArrayList<>();
        String word = String.join("", Arrays.asList(words));
//        indecis.add(s.regionMatches(word));
        return indecis;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords words = new SubstringWithConcatenationOfAllWords();
        System.out.println(words.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
    }
}
