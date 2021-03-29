package com.wilson.leetcode.medium;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * Example 2:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * Example 3:
 *
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 *
 * Constraints:
 *
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 *
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger board?
 *
 * Accepted 633,344 Submissions 1,709,346
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        final int row = board.length;
        final int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && search(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j > board[0].length) return false;
        if (board[i][j] != word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        if (search(board, i + 1, j, word, idx + 1) || search(board, i - 1, j, word, idx + 1) ||
                search(board, i, j + 1, word, idx + 1) || search(board, i, j - 1, word, idx + 1)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, word));
    }
}
