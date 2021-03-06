package com.wilson.leetcode.hard;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 *
 * 1 represents the starting square.  There is exactly one starting square.
 * 2 represents the ending square.  There is exactly one ending square.
 * 0 represents empty squares we can walk over.
 * -1 represents obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * Output: 2
 * Explanation: We have the following two paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * Example 2:
 *
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * Output: 4
 * Explanation: We have the following four paths:
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 *
 * Input: [[0,1],[2,0]]
 * Output: 0
 * Explanation:
 * There is no path that walks over every empty square exactly once.
 * Note that the starting and ending square can be anywhere in the grid.
 *
 *
 * Note:
 *
 * 1 <= grid.length * grid[0].length <= 20
 * Accepted
 * 67,378 Submissions 87,435
 */
public class UniquePathsIII {
    int empty = 1;
    public int uniquePathsIII(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int r = -1, c = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                } else if (grid[i][j] == 0){
                    empty++;
                }
            }
        }
        return dfs(r, c, grid);
    }

    private int dfs(int i, int j, int[][] grid) {
        int count = 0;
        if (i < 0 || i >= grid.length ||  j < 0 || j >= grid[0].length || grid[i][j] == -2 || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            if (empty == 0) return 1;
        }
        int temp = grid[i][j];
        grid[i][j] = -2;
        empty--;
        count += dfs(i + 1, j, grid) + dfs(i, j + 1, grid) + dfs(i - 1, j, grid) + dfs(i, j - 1, grid);
        grid[i][j] = temp;
        empty++;
        return count;
    }

    public static void main(String[] args) {
        UniquePathsIII upiii = new UniquePathsIII();
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        System.out.println(upiii.uniquePathsIII(grid));
    }
}
