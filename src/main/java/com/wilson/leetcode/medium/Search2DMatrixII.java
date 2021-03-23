package com.wilson.leetcode.medium;

/**
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix.
 * The matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -10^9 <= matix[i][j] <= 10^9
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -10^9 <= target <= 10^9
 * Accepted 434,753 Submissions 961,049
 */
public class Search2DMatrixII {
    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null) return false;
        final int m = matrix.length;
        final int n = matrix[0].length;
        if (m == 1) return searchInArray(matrix[0], target);
        int row = -1;
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] > target) {
                row = i - 1;
                break;
            }
        }
        if (row == -1) {
            if (matrix[m - 1][n - 1] < target) return false;
            return searchInArray(matrix[m - 1], target);
        }
        return searchInArray(matrix[row], target);
    }

    private boolean searchInArray(int[] array, int target) {
        final int len = array.length;
        int low = 0, high = len, mid = (high + low) / 2;
        if (array[0] > target || array[len - 1] < target) return false;
        while (low < high) {
            if (array[mid] == target) return true;
            if (array[mid] < target) {
                low = mid + 1;
            }
            if (array[mid] > target) {
                high = mid;
            }
            mid = (high + low) / 2;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        int i = 0, j = n - 1;
        while (i >= 0 && j >= 0 && i < m && j < n) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrixII sdmii = new Search2DMatrixII();
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(sdmii.searchMatrix(matrix, 22));
    }
}
