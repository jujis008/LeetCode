package com.wilson.leetcode.medium;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 * nums is a non decreasing array.
 * -10^9 <= target <= 10^9
 */
public class FindFirstLastPositionElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int right = findRight(nums, target);
        if (right != -1) {
            int left = findLeft(nums, target);
            return new int[] {left, right};
        }
        return new int[]{-1, -1};
    }

    private int findLeft(int[] nums, int target) {
        int len = nums.length, high = len, low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid - 1] != target) && nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int findRight(int[] nums, int target) {
        int len = nums.length, high = len, low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if ((mid == len - 1 || nums[mid + 1] != target) && nums[mid] == target) {
                return mid;
            } else if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        FindFirstLastPositionElementInSortedArray ff = new FindFirstLastPositionElementInSortedArray();
        int[] result = ff.searchRange(nums, 6);
        System.out.println(result[0] + " " + result[1]);
    }
}
