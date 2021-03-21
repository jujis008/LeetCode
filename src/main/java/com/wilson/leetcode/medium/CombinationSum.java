package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * Each element of candidate is unique.
 * 1 <= target <= 500
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) return result;
        List<Integer> current = new ArrayList<>();
        int index = 0;
        dfs(result, current, candidates, target, index);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index == candidates.length) return;
        dfs(result, current, candidates, target, index + 1);
        int cur = candidates[index];
        int count = 0;
        for (int i = 1; (i * cur) <= target; i++) {
            count++;
            current.add(candidates[index]);
            dfs(result, current, candidates, target - (i * cur), index + 1);
        }
        for (int i = 0; i < count; i++) {
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
//        int[] nums = {2, 3, 6, 7};
        int[] nums = {2, 3, 5};
        System.out.println(cs.combinationSum(nums, 7));
    }
}
