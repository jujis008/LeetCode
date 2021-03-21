package com.wilson.leetcode.medium;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 * On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.
 *
 * Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is
 * at the last row and column.
 *
 * Now, we walk in a clockwise spiral shape to visit every position in this grid.
 *
 * Whenever we would move outside the boundary of the grid, we continue our walk outside the grid
 * (but may return to the grid boundary later.)
 *
 * Eventually, we reach all R * C spaces of the grid.
 *
 * Return a list of coordinates representing the positions of the grid in the order they were visited.
 *
 * Example 1:
 *
 * Input: R = 1, C = 4, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1],[0,2],[0,3]]
 *
 * Example 2:
 *
 * Input: R = 5, C = 6, r0 = 1, c0 = 4
 * Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],
 * [4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 *
 * Note:
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 * Accepted
 * 21,504
 * Submissions
 * 30,915
 */
public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int row, int col, int r0, int c0) {
        int[][] result = new int[row * col][2];
        int direction = 0, index = 0, r = r0, c = c0, step = 0, size = 1;
        while (index < row * col) {
            if (r >= 0 && r <= row - 1 && c >= 0 && c <= col - 1) {
                result[index][0] = r;
                result[index][1] = c;
                index++;
            }
            switch (direction) {
                case 0:
                    c++;
                    break;
                case 1:
                    r++;
                    break;
                case 2:
                    c--;
                    break;
                case 3:
                    r--;
                    break;
            }
            step++;
            if (step == size) {
                direction = (direction + 1) % 4;
                if (direction == 0 || direction == 2) {
                    size++;
                }
                step = 0;
            }
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
        SpiralMatrixIII spiii = new SpiralMatrixIII();
        int[][] result = spiii.spiralMatrixIII(5, 6, 1, 4);
        spiii.print(result);
    }
}
