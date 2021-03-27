package com.wilson.leetcode.medium;

import java.util.*;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * Accepted 332,521 Submissions 678,296
 */
public class SubsetsII {
    List<List<Integer>> result = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    int curIdx;
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        final int len = nums.length;
        Arrays.sort(nums);
        for (curIdx = 0; curIdx <= len; ++curIdx) {
            backtrace(0, new ArrayList<>(), nums);
        }
        return result;
    }

    private void backtrace(int start, List<Integer> cur, int[] nums) {
        if (cur.size() == curIdx) {
            String str = cur.toString();
            if (!set.contains(str)) {
                set.add(str);
                result.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            cur.add(nums[i]);
            backtrace(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

    static final int MIN = -10;
    static final int MAX = 10;
    static final int SIZE = MAX - MIN + 1;
    static class Bag {
        final int[] counts = new int[SIZE];

        int get(int num) {
            return counts[num - MIN];
        }

        void add(int num) {
            counts[num - MIN] += 1;
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Bag bag = new Bag();
        for (int num : nums) {
            bag.add(num);
        }
        List<List<Integer>> results = new ArrayList<>();
        step(bag, 0, results);
        return results;
    }

    private void step(Bag bag, int position, List<List<Integer>> results) {
        if (position == SIZE) {
            List<Integer> result = new ArrayList<>();
            for (int i = MIN; i <= MAX; i++) {
                for (int count = 0; count < bag.get(i); count++) {
                    result.add(i);
                }
            }
            results.add(result);
        } else {
            int count = bag.counts[position];
            for (int i = 0; i <= count; i++) {
                bag.counts[position] = i;
                step(bag, position + 1, results);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        SubsetsII s = new SubsetsII();
        System.out.println(s.subsetsWithDup(nums));
        // [[], [1], [2], [2], [1, 2], [1, 2], [2, 2], [1, 2, 2]]
    }
}
