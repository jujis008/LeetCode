package com.wilson.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        final int numRows = rowIndex + 1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRow = new ArrayList<>();
        oneRow.add(1);
        result.add(oneRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = result.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(preRow.get(j) + preRow.get(j - 1));
            }
            row.add(1);
            result.add(row);
        }
        return result.get(rowIndex);
    }

    public List<Integer> getRow1(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }
        return Arrays.asList(arr);
    }


    public static void main(String[] args) {
        PascalsTriangleII pt = new PascalsTriangleII();
        System.out.println(pt.getRow1(6));
    }
}
