package com.wilson.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by i324291 on 2019/3/22.
 */
public class RansomNote {
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) return true;
        if (magazine == null || magazine.length() == 0) return false;
        final int len1 = ransomNote.length();
        Map<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            char ch = ransomNote.charAt(i);
            int idx;
            if (store.containsKey(ch)) {
                idx = magazine.indexOf(ch, store.get(ch) + 1);
            } else {
                idx = magazine.indexOf(ch);
            }
            if (idx > -1) {
                store.put(ch, idx);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            count[ch - 'a']--;
        }
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }
        for (int c : count) {
            if (c < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote rn = new RansomNote();
        System.out.println(rn.canConstruct("a", "b"));
        System.out.println(rn.canConstruct("aa", "bb"));
        System.out.println(rn.canConstruct("aa", "aab"));
        System.out.println(rn.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh"));
    }
}
