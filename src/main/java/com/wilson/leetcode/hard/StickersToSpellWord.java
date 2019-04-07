package com.wilson.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/stickers-to-spell-word/
 *
 * We are given N different types of stickers. Each sticker has a lowercase English word on it.
 * You would like to spell out the given target string by cutting individual letters from your collection of stickers
 * and rearranging them.
 * You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
 * What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.
 *
 * Example 1:
 *
 * Input:
 *
 * ["with", "example", "science"], "thehat"
 * Output:
 *
 * 3
 * Explanation:
 *
 * We can use 2 "with" stickers, and 1 "example" sticker.
 * After cutting and rearrange the letters of those stickers, we can form the target "thehat".
 * Also, this is the minimum number of stickers necessary to form the target string.
 * Example 2:
 * Input:
 *
 * ["notice", "possible"], "basicbasic"
 * Output:
 *
 * -1
 * Explanation:
 *
 * We can't form the target "basicbasic" from cutting letters from the given stickers.
 * Note:
 *
 * stickers has length in the range [1, 50].
 * stickers consists of lowercase English words (without apostrophes).
 * target has length in the range [1, 15], and consists of lowercase English letters.
 * In all test cases, all words were chosen randomly from the 1000 most common US English words,
 * and the target was chosen as a concatenation of two random words.
 * The time limit may be more challenging than usual. It is expected that a 50 sticker test case
 * can be solved within 35ms on average.
 * Created by i324291 on 2019/3/22.
 */
public class StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        if (stickers == null || stickers.length == 0) return -1;
        if (target == null || target.length() == 0) return -1;
        int len = stickers.length;
        int[][] mp = new int[len][26];
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char[] chars = stickers[i].toCharArray();
            for (char ch : chars) {
                mp[i][ch - 'a']++;
            }
        }
        dp.put("", 0);
        return calc(dp, mp, target);
    }

    private int calc(Map<String, Integer> dp, int[][] mp, String target) {
        if (dp.containsKey(target)) return dp.get(target);
        int len = mp.length;
        int length = target.length();
        int ans = Integer.MAX_VALUE;
        int[] targets = new int[26];
        for (int i = 0; i < length; i++) {
            char ch = target.charAt(i);
            targets[ch - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (mp[i][target.charAt(0) - 'a'] == 0) continue;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                if (targets[j] > 0) {
                    for (int k = 0; k < Math.max(0, targets[j] - mp[i][j]); k++) {
                        sb.append((char)('a' + j));
                    }
                }
            }
            int tmp = calc(dp, mp, sb.toString());
            if (tmp != -1) ans = Math.min(ans, 1 + tmp);
        }
        dp.put(target, ans == Integer.MAX_VALUE ? -1 : ans);
        return dp.get(target);
    }

    public static void main(String[] args) {
        StickersToSpellWord stsw = new StickersToSpellWord();
        System.out.println(stsw.minStickers(new String[]{"with", "example", "science"}, "thehat"));
        System.out.println(stsw.minStickers(new String[]{"notice", "possible"}, "basicbasic"));
    }
}
