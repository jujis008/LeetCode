package com.wilson.leetcode.medium;

/**
 * Created by i324291 on 2017/8/31.
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array such that
 * the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0, len = nums.length; i < len; i++) {
            
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII duplicateIII = new ContainsDuplicateIII();
        int[] nums = new int[]{1, 3, 1};
        System.out.println(duplicateIII.containsNearbyAlmostDuplicate(nums, 2, 1));
    }
}
