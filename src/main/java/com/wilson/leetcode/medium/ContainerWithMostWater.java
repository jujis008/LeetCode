package com.wilson.leetcode.medium;

/**
 * Given n non-negative integers a1, a2, ..., an ,
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn
 * such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 Note: You may not slant the container and n is at least 2.
 The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 In this case, the max area of water (blue section) the container can contain is 49.
 Example:

 Input: [1,8,6,2,5,4,8,3,7]
 Output: 49

 * Created by i324291 on 2019/4/7.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length < 3) {
            int min = Math.min(height[0], height[1]);
            return min * min;
        }
        int max = 0, avg = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) max = height[i];
            avg += height[i];
        }
        avg /= height.length;
        System.out.println(avg);
        int result = 0;
        while (max >= avg) {
            int[] idxs = findIndices(height, max);
            if (idxs[0] == idxs[1] || idxs[0] == -1 || idxs[1] == -1) {
                max--;
                continue;
            }
            int dis = idxs[1] - idxs[0];
            if (max * dis > result) result = max * dis;
            max--;
        }
        return result;
    }

    private int[] findIndices(int[] src, int num) {
        int[] res = new int[]{-1, -1};
        int len = src.length;
        for (int i = 0; i < len; i++) {
            if (num <= src[i]) {
                res[0] = i;
                break;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (num <= src[i]) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public int maxArea1(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while (right > left) {
            result = Math.max(result, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        System.out.println(cwmw.maxArea1(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(cwmw.maxArea1(new int[]{1,2}));
        System.out.println(cwmw.maxArea1(new int[]{1,2,1}));
    }
}
