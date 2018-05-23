package com.wilson.leetcode.easy;

/**
 * Created by i324291 on 2018/5/8.
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.

 Example 1:
 Input: [1,2,3]
 Output: 6
 Example 2:
 Input: [1,2,3,4]
 Output: 24
 */
public class MaximumProductThreeNumbers {
    public int maximumProduct(int[] nums) {
        int min1, min2;
        int max1, max2, max3;
        min1 = min2 = Integer.MAX_VALUE;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
    public static void main(String[] args) {
        int[] nums1 = {-1, -2, -3, 23};
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(new MaximumProductThreeNumbers().maximumProduct(nums1));
        System.out.println(new MaximumProductThreeNumbers().maximumProduct(nums2));
    }
}
