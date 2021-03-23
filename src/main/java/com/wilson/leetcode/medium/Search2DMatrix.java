package com.wilson.leetcode.medium;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 * Accepted
 * 430,703 Submissions 1,134,160
 */
public class Search2DMatrix {
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null) return false;
        final int n = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == target) return true;
            }
        }
        return false;
    }

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
        Search2DMatrix sdm = new Search2DMatrix();
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1, 2}};
        System.out.println(sdm.searchMatrix(matrix, 1));
//        int[] arr = {1,3,5,7};
//        System.out.println(sdm.searchInArray(arr, 6));
    }
}
