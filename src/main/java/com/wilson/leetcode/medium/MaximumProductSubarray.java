package com.wilson.leetcode.medium;

/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * Created by i324291 on 2018/5/9.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int init = nums[0];
        for (int i = 1, max = init, min = init, len = nums.length; i < len; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            min = Math.min(nums[i], nums[i] * min);
            max = Math.max(nums[i], nums[i] * max);
            init = Math.max(init, max);
        }
        return init;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-3, 1, -4}));
    }
}
