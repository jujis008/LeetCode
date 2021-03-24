package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * All the numbers of nums are unique.
 * Accepted 738,889 Submissions 1,129,480
 */
public class Subsets {
    List<List<Integer>> output = new ArrayList<>();
    int curIdx;

    public List<List<Integer>> subsets1(int[] nums) {
         List<List<Integer>> results = new ArrayList<>();
         results.add(new ArrayList<>()); // empty set
         for (int i : nums) {
             List<List<Integer>> subsets = new ArrayList<>();
             for (List<Integer> cur : results) {
                 subsets.add(new ArrayList<Integer>(cur){{add(i);}});
             }
             results.addAll(subsets);
         }
         return results;
    }

    public List<List<Integer>> subsets(int[] nums) {
        final int len = nums.length;
        for (curIdx = 0; curIdx <= len; ++curIdx) {
            backtrack(0, new ArrayList<>(), nums);
        }
        return output;
    }

    private void backtrack(int start, List<Integer> cur, int[] nums) {
        if (cur.size() == curIdx) {
            output.add(new ArrayList<>(cur));
            return;
        };
        for (int i = start; i < nums.length; ++i) {
            cur.add(nums[i]);
            backtrack(i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1 ,2 ,2};
        Subsets s = new Subsets();
        System.out.println(s.subsets(nums));
    }
}
