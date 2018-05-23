package com.wilson.leetcode.medium;

import java.util.*;

/**
 * Created by i324291 on 2018/3/15.
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        final int len = s.length();
        if (len == 0) return len;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0, j = 0; i < len; ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters st = new LongestSubstringWithoutRepeatingCharacters();
        String sr = "pwwkew";
        System.out.println(st.lengthOfLongestSubstring(sr));
        Set<String> s = new HashSet<>();
        Set<String> s1 = new HashSet<>();
        s.add("resource:data:DC13");
        s.add("resource:data:DC14");
        s.add("resource:data:DC15");
        s.add("resource:data:DC16");
//        s.add("**");
        System.out.println(s);
        for (String p : s) {
            int idx = p.indexOf("resource:data:");
            if (idx > -1) {
                s1.add(p.substring("resource:data:".length() + idx));
            }
        }
        if (s.contains("*")) {
            System.out.println(true);
        }
        List<String> l = new ArrayList<>();
        l.addAll(s1);
        System.out.println(l);
        String[] sk = convertToArray(s1);
        for (String o : sk) {
            System.out.println(o);
        }

    }

    private static String[] convertToArray(Set<String> permissionSet) {
        if (permissionSet == null) return new String[]{};
        final int len = permissionSet.size();
        String[] permissions;
        if (len > 0) {
            permissions = new String[len];
            int c = 0;
            for (String p : permissionSet) {
                permissions[c++] = p;
            }
            return permissions;
        }
        return new String[]{};
    }
}
