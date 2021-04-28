package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 *
 *
 * Example 1:
 *
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 *
 * Input: triangle = [[-10]]
 * Output: -10
 *
 *
 * Constraints:
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 *
 *
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int len = triangle.size();
        if (len < 1) return 0;
       List<Integer> dp = new ArrayList<>(triangle.get(len - 1));
       for (int i = len - 2; i >= 0; i--) {
           for (int j = 0; j <= i; j++) {
               dp.set(j, Math.min(dp.get(j), dp.get(j+1)) + triangle.get(i).get(j));
           }
       }
       return dp.get(0);
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        int[][] arr = {{2},{3,4},{6,5,7},{4,1,8,3}};
//        int[][] arr = {{-10}};
        List<List<Integer>> list = new ArrayList<>();
        for (int[] a : arr) {
            List<Integer> row = new ArrayList<>();
            for (int i : a) {
                row.add(i);
            }
            list.add(row);
        }
        System.out.println(t.minimumTotal(list));
    }
}
