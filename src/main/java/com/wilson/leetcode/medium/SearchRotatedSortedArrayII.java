package com.wilson.leetcode.medium;

/**
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums is guaranteed to be rotated at some pivot.
 * -10^4 <= target <= 10^4
 *
 *
 * Follow up: This problem is the same as Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the runtime complexity? How and why?
 * Accepted
 * 297,688 Submissions 884,946
 */
public class SearchRotatedSortedArrayII {
    public boolean search1(int[] nums, int target) {
        if (nums.length == 0) return false;
        for (int num : nums) {
            if (target == num) return true;
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        final int len = nums.length;
        if (len == 0) return false;
        int high = len - 1, low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            if (!isBinarySearchHelpful(nums, low, nums[mid])) {
                low++;
                continue;
            }
            boolean pivotArray = existsInFirst(nums, low, nums[mid]);
            boolean targetArray = existsInFirst(nums, low, target);
            if (pivotArray ^ targetArray) { // If pivot and target exist in different sorted arrays,
                // recall that xor is true when both operands are distinct
                if (pivotArray) {
                    low = mid + 1; // pivot in the first, target in the second
                } else {
                    high = mid - 1; // target in the first, pivot in the second
                }
            } else { // If pivot and target exist in same sorted array
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }

    private boolean isBinarySearchHelpful(int[] nums, int low, int num) {
        return nums[low] != num;
    }

    private boolean existsInFirst(int[] arr, int start, int element) {
        return arr[start] <= element;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArrayII srsa = new SearchRotatedSortedArrayII();
        int[] nums = {4,5,6,6,7,0,1,2,4,4};
        System.out.println(srsa.search(nums, 3));
    }
}
