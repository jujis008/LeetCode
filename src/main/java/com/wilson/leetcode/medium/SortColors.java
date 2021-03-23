package com.wilson.leetcode.medium;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is 0, 1, or 2.
 *
 *
 * Follow up:
 *
 * Could you solve this problem without using the library's sort function?
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 * Accepted 647,996 Submissions 1,305,563
 */
public class SortColors {
    public void sortColors(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
        final int len = nums.length;
        int redCount = 0, whiteCount = 0, blueCount = 0;
        for (int i : nums) {
            if (i > 1) {
                blueCount++;
            } else if (i < 1) {
                redCount++;
            } else {
                whiteCount++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (redCount-- > 0) {
                nums[i] = 0;
                continue;
            }
            if (whiteCount-- > 0) {
                nums[i] = 1;
                continue;
            }
            if (blueCount-- > 0) {
                nums[i] = 2;
            }
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low > high) return;
        int i = low, j = high, temp = arr[low];
        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low,  j - 1);
        quickSort(arr, j + 1, high);
    }

    public static void main(String[] args) {
        SortColors sc = new SortColors();
        int[] nums = {1};
        sc.sortColors(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
