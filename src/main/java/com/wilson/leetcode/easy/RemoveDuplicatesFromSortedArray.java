package com.wilson.leetcode.easy;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    final int len = nums.length;
    if (len == 0) return 0;
    int mark = 0, count = 1;
    for (int i = 1; i < len; i++) {
      if (nums[i] > nums[mark]) {
        nums[++mark] = nums[i];
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {0,0,1,1,1,2,2,3,3,4};
    int[] nums1 = {1, 1, 2};
    RemoveDuplicatesFromSortedArray rdfsa = new RemoveDuplicatesFromSortedArray();
//    long start = System.currentTimeMillis();
    System.out.println(rdfsa.removeDuplicates(nums));
    System.out.println(rdfsa.removeDuplicates(nums1));
//    System.out.println(System.currentTimeMillis() - start);
  }
}
