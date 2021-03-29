package com.wilson.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 10^5
 * 0 <= heights[i] <= 10^4
 * Accepted 348,461 Submissions 933,264
 */
public class LargestRectangleHistogram {
    public int largestRectangleArea1(int[] heights) {
        final int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        Stack<Integer> stack = new Stack<>();
        int maxArea = heights[0];
        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                int preIdx = stack.isEmpty() ? -1 : stack.peek();
                int area = curHeight * (i - preIdx - 1);
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public int largestRectangleArea2(int[] heights) {
        final int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        Stack<Integer> stack = new Stack<>();
        int maxArea = heights[0];
        for (int i = 0; i <= len; i++) {
            int h = i == len ? 0 : heights[i];
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                i--;
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        final int len = heights.length;
        if (len == 0) return 0;
        if (len == 1) return heights[0];
        int[] A1 = new int[len];
        int[] A2 = new int[len];
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty() && heights[i] <= heights[queue.peekLast()]) {
                queue.removeLast();
            }
            A1[i] = (queue.isEmpty() ? -1 : queue.peekLast());
            queue.addLast(i);
        }
        System.out.println(Arrays.toString(A1));
        for (int i = len - 1; i >= 0; i--) {
            while (!queue2.isEmpty() && heights[i] <= heights[queue2.peekLast()]) {
                queue2.removeLast();
            }
            A2[i] = (queue2.isEmpty() ? len : queue2.peekLast());
            queue2.addLast(i);
        }
        System.out.println(Arrays.toString(A2));
        int maxArea = heights[0];
        for (int i = 0; i < len; i++) {
            int width = (A2[i] - A1[i] - 1);
            int curArea = width * heights[i];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram lrh = new LargestRectangleHistogram();
        int[] nums = {2,1,5,6,2,3};
//        int[] nums = {2,4};
//        int[] nums = {1,1};
        System.out.println(lrh.largestRectangleArea(nums));
    }
}
