package com.wilson.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * Example 3:
 *
 * Input: intervals = [], newInterval = [5,7]
 * Output: [[5,7]]
 * Example 4:
 *
 * Input: intervals = [[1,5]], newInterval = [2,3]
 * Output: [[1,5]]
 * Example 5:
 *
 * Input: intervals = [[1,5]], newInterval = [2,7]
 * Output: [[1,7]]
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= intervals[i][0] <= intervals[i][1] <= 105
 * intervals is sorted by intervals[i][0] in ascending order.
 * newInterval.length == 2
 * 0 <= newInterval[0] <= newInterval[1] <= 105
 * Accepted 336,843 Submissions 956,667
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            intervals = new int[1][];
            intervals[0] = newInterval;
            return intervals;
        }
        List<int[]> result = new LinkedList<>();
        boolean flag = false;
        for (int[] rows : intervals) {
            if (!flag) {
                if (rows[1] < newInterval[0]) {
                    result.add(rows);
                } else if(rows[0] > newInterval[1]){
                    result.add(newInterval);
                    result.add(rows);
                    flag = true;
                } else {
                    newInterval[0] = Math.min(rows[0], newInterval[0]);
                    newInterval[1] = Math.max(rows[1], newInterval[1]);
                }
            } else {
                result.add(rows);
            }
        }
        if (!flag) result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] intervals = {{1,2},{3,5},{6, 7},{8,10},{12,16}};
        int[] newInterval = {4, 8};
        for (int[] rows : ii.insert(intervals, newInterval)) {
            for (int val : rows) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
