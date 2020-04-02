package com.wilson.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 *
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveElement {
  public int removeElement(int[] nums, int val) {
    int len = nums.length;
    if (len == 0) return 0;
    if (len == 1) return nums[0] == val ? 0 : 1;
//    for (int i = 0; i < len; i++) {
//      if (nums[i] == val) {
//        nums[i--] = nums[len-- -1];
//      }
//    }
    for (int i = 0; i < len; i++) {
      if (nums[i] == val) {
        System.arraycopy(nums, i + 1, nums, i, len - (i + 1));
        len--;
        i--;
      }
    }
    return len;
  }

  public static void main(String[] args) {
    RemoveElement re = new RemoveElement();
    int[] nums = {0,1,2,2,3,0,4,2};
    System.out.println(re.removeElement(nums, 2));
  }
}
