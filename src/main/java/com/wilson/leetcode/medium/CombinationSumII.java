package com.wilson.leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) return result;
        int index = 0;
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        dfs(result, current, candidates, target, index);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(current);
            return;
        }
        final int len = candidates.length;
        if (index == len) return;
        for (int i = index; i < len && candidates[i] <= target; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(candidates[i]);
            dfs(result, newCurrent, candidates, target - candidates[i], i + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        CombinationSumII combinationSumII = new CombinationSumII();
        System.out.println(combinationSumII.combinationSum(nums, 8));
    }

}
