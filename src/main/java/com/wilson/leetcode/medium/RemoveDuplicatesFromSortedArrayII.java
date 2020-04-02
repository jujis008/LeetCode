package com.wilson.leetcode.medium;

import java.util.Arrays;

/**
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,1,2,3,3],
 *
 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    int len = nums.length;
    if (len < 3) return len;
    int mark = 1, cur = nums[0];
    int cnt = 1;
    for (int i = 1; i < len; i++) {
      if (cur == nums[i]) {
        cnt++;
      } else {
        cur = nums[i];
        cnt = 1;
      }
      if (cnt < 3) mark++;
      nums[mark - 1] = nums[i];
    }
//    System.out.println(Arrays.toString(nums));
    return mark;
//    int i = 1, j = 2;
//    while (j < len) {
//      if (nums[i] == nums[j] && nums[i - 1] == nums[j]) j++;
//      else nums[++i] = nums[j++];
//    }
//    System.out.println(Arrays.toString(nums));
//    return i + 1;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedArrayII rdfsa = new RemoveDuplicatesFromSortedArrayII();
    int[] nums = {0,0,1,1,1,1,2,3,3};
    int[] nums1 = {1,1,1,2,2,3};
    System.out.println(rdfsa.removeDuplicates(nums));
    System.out.println(rdfsa.removeDuplicates(nums1));
  }
}
