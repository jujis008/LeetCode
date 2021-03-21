package com.wilson.leetcode.medium;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * Accepted
 * 206,751
 * Submissions
 * 377,616
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) return result;
        if (n == 1) {
            result[0][0] = 1;
            return result;
        }
        int count = 1;
        boolean[][] visited = new boolean[n][n];
        dfs(result, 0, 0, visited, count);
        return result;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited, int count) {
        final int len = matrix.length;
        if (i < 0 || i > len - 1 || j < 0 || j > len - 1 || visited[i][j]) return;
        visited[i][j] = true;
        matrix[i][j] = count++;
        if (j - 1 < 0 || visited[i][j - 1]) {
            dfs(matrix, i - 1, j, visited, count);
        }
        if (j + 1 == len || visited[i][j + 1]) {
            dfs(matrix, i + 1, j, visited, count);
        }
        if (i + 1 == len || visited[i + 1][j]) {
            dfs(matrix, i, j - 1, visited, count);
        }
        if (i - 1 < 0 || visited[i - 1][j]) {
            dfs(matrix, i, j + 1, visited, count);
        }
    }

    public int[][] generateMatrix1(int n) {
        int[][] result = new int[n][n];
        if (n == 0) return result;
        if (n == 1) {
            result[0][0] = 1;
            return result;
        }
        int left = 0, right = n - 1, top = 0, bottom = n - 1, len = n * n, c = 1;
        while (len > 0) {
            for (int i = left; i <= right && len > 0; i++) {
                result[top][i] = c++;
                len--;
            }
            top++;
            for (int i = top; i <= bottom && len > 0; i++) {
                result[i][right] = c++;
                len--;
            }
            right--;
            for (int i = right; i >= left && len > 0; i--) {
                result[bottom][i] = c++;
                len--;
            }
            bottom--;
            for (int i = bottom; i >= top && len > 0; i--) {
                result[i][left] = c++;
                len--;
            }
            left++;
        }
        return result;
    }

    private void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j : ints) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SpiralMatrixII spii = new SpiralMatrixII();
        int[][] ints = spii.generateMatrix(4);
        spii.print(ints);
    }
}
