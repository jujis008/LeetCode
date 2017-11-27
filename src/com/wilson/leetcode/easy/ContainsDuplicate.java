package com.wilson.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by i324291 on 2017/8/29.
 *
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int i = 0, len = nums.length; i < len - 1; i++) {
            result = nums[i]^nums[i+1];
            if (result == 0) return true;
        }
        return result == 0;
    }

    public boolean containsDuplicates(int[] nums) {
        Set<Integer> numSet = new HashSet<>(nums.length);
        for(int x : nums) {
            if (numSet.contains(x)) {
                return true;
            }
            numSet.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate duplicate = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1};
        System.out.println(duplicate.containsDuplicates(nums));
    }
}
