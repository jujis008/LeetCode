package com.wilson.leetcode.hard;

/**
 * Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.

 A subsequence of a string S is obtained by deleting 0 or more characters from S.

 A sequence is palindromic if it is equal to the sequence reversed.

 Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

 Example 1:
 Input:
 S = 'bccb'
 Output: 6
 Explanation:
 The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
 Note that 'bcb' is counted only once, even though it occurs twice.
 Example 2:
 Input:
 S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
 Output: 104860361
 Explanation:
 There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
 Note:

 The length of S will be in the range [1, 1000].
 Each character S[i] will be in the set {'a', 'b', 'c', 'd'}.
 * Created by i324291 on 2019/3/12.
 * https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109507/Java-96ms-DP-Solution-with-Detailed-Explanation
 */
public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String s) {
        final int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                int k = j + i;
                if (s.charAt(j) == s.charAt(k)) {
                    int low = j + 1;
                    int high = k - 1;
                    while (low <= high && s.charAt(low) != s.charAt(k)) {
                        low++;
                    }
                    while (low <= high && s.charAt(high) != s.charAt(k)) {
                        high--;
                    }
                    if (low > high) {
                        dp[j][k] = dp[j + 1][k - 1] * 2 + 2;
                    } else if (low == high) {
                        dp[j][k] = dp[j + 1][k - 1] * 2 + 1;
                    } else {
                        dp[j][k] = dp[j + 1][k - 1] * 2 - dp[low + 1][high - 1];
                    }
                } else {
                    dp[j][k] = dp[j][k - 1] + dp[j + 1][k] - dp[j + 1][k - 1];
                }
                dp[j][k] = dp[j][k] < 0 ? dp[j][k] + 1000000007 : dp[j][k] % 1000000007;
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        CountDifferentPalindromicSubsequences cdps = new CountDifferentPalindromicSubsequences();
        System.out.println(cdps.countPalindromicSubsequences("bccb"));
    }
}
