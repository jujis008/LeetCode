package com.wilson.leetcode.medium;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 * <p>
 * <p>
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 * Accepted
 * 357,426 Submissions 1,011,882
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        if (obstacleGrid[0][0] == 1) return 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                flag = 1;
            } else {
                if (flag == 1)
                    dp[0][i] = 0;
                else
                    dp[0][i] = 1;
            }
        }
        flag = 0;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                flag = 1;
            } else {
                if (flag == 1)
                    dp[i][0] = 0;
                else
                    dp[i][0] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        final int m = obstacleGrid.length;
        final int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] grids = new int[m][n];
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            grids[i][j] = -1;
        }
        return dfs(obstacleGrid, 0, 0, m - 1, n - 1, grids);
    }

    private static int dfs(int[][] data, int i, int j, int m, int n, int[][] grids) {
        if (grids[i][j] > -1) {
            return grids[i][j];
        }
        if (i == m && j == n) {
            if (data[i][j] == 1) return 0;
            return 1;
        } else if (i > m || j > n) {
            return 0;
        }
        if (data[i][j] == 1) {
            grids[i][j] = 0;
            return 0;
        }
        int left = dfs(data, i + 1, j, m, n, grids);
        int right = dfs(data, i, j + 1, m, n, grids);
        grids[i][j] = left + right;
        return left + right;
    }

    public int uniquePathsWithObstacles3(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) {
            return 0;
        }

        int m = obstacleGrid[0].length;
        if (m == 0) {
            return 0;
        }

        int[][] memo = new int[2][m + 1];
        memo[1][m - 1] = 1;

        int curRow = 0;
        int otherRow = 1;

        for (int row = n - 1; row >= 0; row--) {
            for (int col = m - 1; col >= 0; col--) {
                if (obstacleGrid[row][col] == 0) {
                    memo[curRow][col] = memo[otherRow][col] + memo[curRow][col + 1];
                } else {
                    memo[curRow][col] = 0;
                }
            }

            int tmp = curRow;
            curRow = otherRow;
            otherRow = tmp;
        }
        return memo[otherRow][0];
    }

    public static void main(String[] args) {
        UniquePathsII upii = new UniquePathsII();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        System.out.println(upii.uniquePathsWithObstacles(obstacleGrid));
        System.out.println(upii.uniquePathsWithObstacles1(obstacleGrid));
        System.out.println(upii.uniquePathsWithObstacles2(obstacleGrid));
        System.out.println(upii.uniquePathsWithObstacles3(obstacleGrid));
    }
}
