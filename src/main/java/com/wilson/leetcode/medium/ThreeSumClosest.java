package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    int length = nums.length;
    int minDiff = Integer.MAX_VALUE;
    int sum = 0;
    int result = 0;
    if (length == 0) return sum;
    Arrays.sort(nums);
    for (int i = 0; i < length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int first = i + 1;
      int last = length - 1;
      while (first < last) {
        sum = nums[i] + nums[first] + nums[last];
        if (sum == target) return sum;
        if (sum < target) first++;
        if (sum > target) last--;
        if (Math.abs(sum - target) < minDiff) {
          minDiff = Math.abs(sum - target);
          result = sum;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {-4, -1, 1, 2};

    ThreeSumClosest threeSumClosest = new ThreeSumClosest();
    System.out.println(threeSumClosest.threeSumClosest(nums, 1));
  }
}
