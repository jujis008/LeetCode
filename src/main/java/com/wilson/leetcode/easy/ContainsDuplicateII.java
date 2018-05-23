package com.wilson.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by i324291 on 2017/8/30.
 *
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j]
 * and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i  > k) set.remove(nums[i - k -1]);
            if (! set.add(nums[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII duplicateII = new ContainsDuplicateII();
        int[] nums = new int[]{1, 0, 1, 1};
        System.out.println(duplicateII.containsNearbyDuplicate(nums, 1));
    }
}
