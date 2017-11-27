package com.wilson.leetcode.hard;

/**
 * Created by i324291 on 2017/8/24.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2, 3, 1, 1, 4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGameII {

    public boolean canJump(int[] nums) {
        final int len = nums.length;
        int lastPosition = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) lastPosition = i;
        }
        return lastPosition == 0;
    }

    public int minJump(int[] nums) {
        final int len = nums.length;
        int maxStep = 0;
        int step = 0;
        int jumpCount = 0;
        for (int i = 0; i < len - 1; i++) {
            maxStep = Math.max(i + nums[i], maxStep);
            if (i == step) {
                step = maxStep;
                jumpCount++;
            }
        }
        return jumpCount;
    }

    public static void main(String[] args) {
        //index 0, 1, 2, 3, 4
        //array 2, 3, 1, 1, 4
        //count 2, 4, 3, 4, 8  //i + nums[i]

        //index 0, 1, 2, 3, 4  5
        //array 2, 3, 1, 0, 1, 4
        //count 2, 4, 3, 3, 5, 9    //i + nums[i]
        int[] nums = new int[] {2, 3, 1, 0, 1, 4};
        JumpGameII gameII = new JumpGameII();
        System.out.println(gameII.canJump(nums));
        System.out.println(gameII.minJump(nums));
    }
}
