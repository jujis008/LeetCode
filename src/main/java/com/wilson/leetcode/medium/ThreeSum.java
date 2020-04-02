package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by i324291 on 2018/6/12.
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * */
public class ThreeSum {
  private List<List<Integer>> result;

  public List<List<Integer>> nSum(int[] nums, int target, int n) {
    result = new ArrayList<>();
    Arrays.sort(nums);
    helper(nums, 0, target, n, new Integer[n]);
    return result;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    return nSum(nums, 0, 3);
  }

  public void helper(int[] nums, int start, int target, int count, Integer[] arr) {
    if (count == 0) {
      if (target == 0) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        result.add(list);
      }
      return;
    }
    if (count == 2) {
      twoSum(nums, start, target, arr);
      return;
    }
    int last = Integer.MAX_VALUE;
    for (int i = start, len = nums.length; i < len; i++) {
      if (nums[i] != last) {
        last = nums[i];
        arr[arr.length - count] = nums[i];
        helper(nums, i + 1, target - nums[i], count - 1, arr);
      }
    }
  }

  public void twoSum(int[] nums, int start, int target, Integer[] arr) {
    int lastMin = Integer.MIN_VALUE;
    int lastMax = Integer.MAX_VALUE;
    int i = start;
    int j = nums.length - 1; 
    while(i < j) {
      if (nums[i] + nums[j] == target) {
        arr[arr.length - 2] = nums[i];
        arr[arr.length - 1] = nums[j];
        result.add(new ArrayList<>(Arrays.asList(arr)));
        lastMin = nums[i];
        lastMax = nums[j];
        i++;
        j--;
      } else if (nums[i]+nums[j] > target) {
        lastMax = nums[j];
        j--;
      } else {
        lastMin = nums[i];
        i++;
      }
      while(i < j && nums[i] == lastMin) {
        i++;
      }
      while(i < j && nums[j] == lastMax) {
        j--;
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(4 << 16));
    System.out.println(Integer.toBinaryString(4 << 16 | 0 << 8 | 0));
    System.out.println(Integer.toBinaryString(5 << 16 | 0 << 8 | 0));
    System.out.println(Integer.toBinaryString(6 << 16 | 0 << 8 | 0));

    int[] nums = {-1, 0, 1, 2, -1, -4};
    ThreeSum threeSum = new ThreeSum();
    System.out.println(threeSum.threeSum(nums));
  }
}
