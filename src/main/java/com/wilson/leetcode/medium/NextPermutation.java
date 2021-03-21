package com.wilson.leetcode.medium;

/**
 * https://leetcode.com/problems/next-permutation/
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1) return;
        int k = len - 2;
        while (k >= 0 && nums[k+1] <= nums[k]) k--;
        if (k >= 0) {
            int m = len - 1;
            while (m >= 0 && nums[m] <= nums[k]) m--;
            if (k < m) {
                swap(nums, k, m);
            }
        }
        reverse(nums, k + 1, len - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 1};
//        int[] nums = {1, 2, 1};
        int[] nums = {5, 1, 1};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
