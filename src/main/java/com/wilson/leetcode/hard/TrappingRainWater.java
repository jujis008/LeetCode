package com.wilson.leetcode.hard;

/**
 *
 * https://leetcode.com/problems/trapping-rain-water/
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 * 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {

    /**
     * DP
     * @param height
     * @return
     */
    public int trap(int[] height) {
        final int len = height.length;
        if (len == 0) return 0;
        int result = 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            result += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return result;
    }

    /**
     * brute force
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        final int len = height.length;
        int result = 0;
        if (len < 3) return result;
        for (int i = 1; i < len - 1; i++) {
            int leftMax=0, rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < len; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            result += Math.min(leftMax, rightMax) - height[i];
        }
        return result;
    }

    public int trap2(int[] height) {
        final int len = height.length;
        if (len < 3) return 0;
        int left = 0, right = len - 1, leftMax = height[left], rightMax = height[right], result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    result += (leftMax - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += (rightMax - height[result]);
                }
                --right;
            }
        }
        return result;
    }

    public int trap1(int[] height) {
        final int len = height.length;
        if (len < 3) return 0;
        int left = 0, right = len - 1, leftMax = height[left], rightMax = height[right], result = 0;
        while (left < right) {
            result += ((leftMax = Math.max(leftMax, height[left])) < (rightMax = Math.max(rightMax, height[right]))) ? leftMax - height[left++] : rightMax - height[right--];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trw = new TrappingRainWater();
        System.out.println(trw.trap(data));
    }
}
