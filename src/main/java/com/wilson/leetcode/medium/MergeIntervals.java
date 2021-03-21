package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        if (intervals == null || intervals.length < 2) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] rows : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < rows[0]) result.add(rows);
            else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], rows[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
//        int[][] intervals = {{1,4}, {4,5}};
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        for (int[] rows : mi.merge(intervals)) {
            for (int val : rows) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
