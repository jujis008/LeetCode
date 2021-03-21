package com.wilson.leetcode.hard;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 *
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 * Follow up:
 *
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int i = 1;
        while (set.contains(i)) i++;
        return i;
    }

    public int firstMissingPositive3(int[] nums) {
        final int len = nums.length;
        if (len == 0) return 1;
        int[] bucket = new int[len];
        for (int num : nums) {
            if (num > 0 && num <= len) {
                bucket[num - 1]++;
            }
        }
        print(bucket);
        int i = 0;
        while (i < len && bucket[i] != 0) {
            i++;
        }
        return i + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        final int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        print(nums);
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        print(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return len + 1;
    }
    public int firstMissingPositive1(int[] nums) {
        final int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                print(nums);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0};
//        int[] nums = {3,4,-1,10};
//        int[] nums = {7,8,9,11,12};
//        int[] nums = {2, 1, 4, 3};
//        int[] nums = {3, 2, 1};
        FirstMissingPositive fmp = new FirstMissingPositive();
        System.out.println(fmp.firstMissingPositive(nums));
    }
}
