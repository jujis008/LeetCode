package com.wilson.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given two positive integer arrays nums1 and nums2, both of length n.
 * <p>
 * The absolute sum difference of arrays nums1 and nums2 is defined as the sum of |nums1[i] - nums2[i]| for each 0 <= i < n (0-indexed).
 * <p>
 * You can replace at most one element of nums1 with any other element in nums1 to minimize the absolute sum difference.
 * <p>
 * Return the minimum absolute sum difference after replacing at most one element in the array nums1. Since the answer may be large,
 * return it modulo 10^9 + 7.
 * <p>
 * |x| is defined as:
 * <p>
 * x if x >= 0, or
 * -x if x < 0.
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,5], nums2 = [2,3,5]
 * Output: 3
 * Explanation: There are two possible optimal solutions:
 * - Replace the second element with the first: [1,7,5] => [1,1,5], or
 * - Replace the second element with the third: [1,7,5] => [1,5,5].
 * Both will yield an absolute sum difference of |1-2| + (|1-3| or |5-3|) + |5-5| = 3.
 * Example 2:
 * <p>
 * Input: nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
 * Output: 0
 * Explanation: nums1 is equal to nums2 so no replacement is needed. This will result in an
 * absolute sum difference of 0.
 * Example 3:
 * <p>
 * Input: nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
 * Output: 20
 * Explanation: Replace the first element with the second: [1,10,4,4,2,7] => [10,10,4,4,2,7].
 * This yields an absolute sum difference of |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums1.length
 * n == nums2.length
 * 1 <= n <= 10^5
 * 1 <= nums1[i], nums2[i] <= 10^5
 */
public class MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;
        if (len1 != len2) return 0;
        long sum = 0;
        int maxDiffIdx = 0, maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < len1; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum += diff;
            if (diff > maxDiff) {
                maxDiff = diff;
                maxDiffIdx = i;
            }
        }
        int replaceDiff = maxDiff;
        for (int i : nums1) {
            int diff = Math.abs(i - nums2[maxDiffIdx]);
            if (diff < replaceDiff) replaceDiff = diff;
            if (diff == 0) break;
        }
        long result = (sum - maxDiff + replaceDiff);
        return (int) (result % (1e9 + 7));
    }

    public int minAbsoluteSumDiff1(int[] nums1, int[] nums2) {
        final int len = nums1.length;
        if (len != nums2.length) return 0;
        long sum = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum += diff;
            set.add(nums1[i]);
        }
        long minDiff = sum;
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            for (int j = 0; j <= diff; j++) {
                if (set.contains(nums2[i] + j) || set.contains(nums2[i] - j)) {
                    minDiff = Math.min(minDiff, sum + j - diff);
                    break;
                }
            }
        }
        return (int) (minDiff % (1e9 + 7));
    }

    public static void main(String[] args) {
        MinimumAbsoluteSumDifference masd = new MinimumAbsoluteSumDifference();
//        int[] num1 = {1,7,5};
//        int[] num2 = {2,3,5};
        int[] num1 = {1, 28, 21};
        int[] num2 = {9, 21, 20};
//        int[] num1 = {1,10,4,4,2,7};
//        int[] num2 = {9,3,5,1,7,4};
//        int[] num1 = {57,42,21,28,30,25,22,12,55,3,47,18,43,29,20,44,59,9,43,7,8,5,42,53,99,34,37,88,87,62,38,68,31,3,11,61,93,34,63,27,20,48,38,5,71,100,88,54,52,15,98,59,74,26,81,38,11,44,25,69,79,81,51,85,59,84,83,99,31,47,31,23,83,70,82,79,86,31,50,17,11,100,55,15,98,11,90,16,46,89,34,33,57,53,82,34,25,70,5,1};
//        int[] num2 = {76,3,5,29,18,53,55,79,30,33,87,3,56,93,40,80,9,91,71,38,35,78,32,58,77,41,63,5,21,67,21,84,52,80,65,38,62,99,80,13,59,94,21,61,43,82,29,97,31,24,95,52,90,92,37,26,65,89,90,32,27,3,42,47,93,25,14,5,39,85,89,7,74,38,12,46,40,25,51,2,19,8,21,62,58,29,32,77,62,9,74,98,10,55,25,62,48,48,24,21};

        System.out.println(masd.minAbsoluteSumDiff(num1, num2));
    }
}
