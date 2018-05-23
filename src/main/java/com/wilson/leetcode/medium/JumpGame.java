package com.wilson.leetcode.medium;

/**
 * Created by i324291 on 2017/8/23.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        final int len = nums.length;
        int lastPosition = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) lastPosition = i;
        }
        return lastPosition == 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,0,8,2,0,0,1};//{2, 3, 1, 1, 4};
        int[] nums2 = new int[]{3, 2, 1, 0, 4};
        int[] nums3 = new int[]{2, 5, 0, 0};
        JumpGame game = new JumpGame();
        System.out.println(game.canJump(nums1));
        System.out.println(game.canJump(nums2));
        System.out.println(game.canJump(nums3));
    }
}
