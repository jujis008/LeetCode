package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * Accepted 406,611  Submissions 1,178,765
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        dfs(matrix, 0, 0, result, visited);
        return result;
    }

    private void dfs(int[][] matrix, int i, int j, List<Integer> result, boolean[][] visited) {
        int row = matrix.length, col = matrix[0].length;
        if (i < 0 || i > row - 1 || j < 0 || j > col - 1 || visited[i][j]) return;
        result.add(matrix[i][j]);
        visited[i][j] = true;
        if (j - 1 < 0 || visited[i][j - 1]) {
            dfs(matrix, i - 1, j, result, visited);
        }
        if (j + 1 == col || visited[i][j + 1]) {
            dfs(matrix, i + 1, j, result, visited);
        }
        if (i + 1 == row || visited[i + 1][j]) {
            dfs(matrix, i, j - 1, result, visited);
        }
        if (i - 1 < 0 || visited[i - 1][j]) {
            dfs(matrix, i, j + 1, result, visited);
        }
    }


    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        final int row = matrix.length;
        if (row < 2) {
            for (int m : matrix[0]) {
                result.add(m);
            }
            return result;
        }
        final int col = matrix[0].length;
        if (col < 2) {
            for (int[] ints : matrix) {
                result.add(ints[0]);
            }
            return result;
        }
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        int len = row * col;
        while (len > 0) {
            for (int i = left; i <= right && len > 0; i++) {
                result.add(matrix[top][i]);
                len--;
            }
            top++;
            for (int i = top; i <= bottom && len > 0; i++) {
                result.add(matrix[i][right]);
                len--;
            }
            right--;
            for (int i = right; i >= left && len > 0; i--) {
                result.add(matrix[bottom][i]);
                len--;
            }
            bottom--;
            for (int i = bottom; i >= top && len > 0; i--) {
                result.add(matrix[i][left]);
                len--;
            }
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8 , 9}};
//        int[][] data = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix sp = new SpiralMatrix();
        List<Integer> result = sp.spiralOrder(data);
        System.out.println(result);
    }
}
