package com.wilson.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
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
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) return result;
        List<Integer> oneRow = new ArrayList<>();
        oneRow.add(1);
        List<Integer> twoRows = new ArrayList<>();
        twoRows.add(1);
        twoRows.add(1);
        result.add(oneRow);
        if (numRows == 1) {
            return result;
        }
        result.add(twoRows);
        if (numRows == 2) {
            return result;
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> lastRow = result.get(result.size() - 1);
            for (int j = 0; j < lastRow.size() - 1; j++) {
                row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows < 1) return result;
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
        return result;
    }


    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.generate1(6));
    }
}
