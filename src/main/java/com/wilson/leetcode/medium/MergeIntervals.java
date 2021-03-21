package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 *
 *
 * Constraints:
 *
 * intervals[i][0] <= intervals[i][1]
 * Accepted 676,810  Submissions 1,704,900
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        final int row = intervals.length;
        final int col = intervals[0].length;
        int[][] result = new int[row][col];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for(int j = i + 1; j < row - 1; j++) {
                if (intervals[i][1] >= intervals[j][0] && intervals[j][1] >= intervals[i][0]) {

                }
            }
        }
        return null;
    }
}
