package com.wilson.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 * Accepted 288,465 Submissions 772,642
 */
public class WordSearchII {
    public List<String> findWords1(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            label: for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j] && findWord(board, i, j, word, 0)) {
                        result.add(word);
                        break label;
                    }
                }
            }
        }
        return result;
    }

    private boolean findWord(char[][] board, int i, int j, String word, int idx) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        char temp = board[i][j];
        boolean res = false;
        if (temp == word.charAt(idx)) {
            if (idx == word.length() - 1) return true;
            board[i][j] = '*';
            res = findWord(board, i + 1, j, word, idx + 1) ||
                findWord(board, i - 1, j, word, idx + 1) ||
                findWord(board, i, j + 1, word, idx + 1) ||
                findWord(board, i, j - 1, word, idx + 1);
            board[i][j] = temp;
        }
        return res;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (current.children[i] == null) {
                    current.children[i] = new TrieNode();
                }
                current = current.children[i];
            }
            current.word = word;
        }
        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        char c = board[i][j];
        if (c == '*' || root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }
        board[i][j] = '*';
        if (i > 0) dfs(board, i - 1, j, root, result);
        if (i < board.length - 1) dfs(board, i + 1, j, root, result);
        if (j > 0) dfs(board, i, j - 1, root, result);
        if (j < board[0].length - 1) dfs(board, i, j + 1, root, result);
        board[i][j] = c;
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"rain","oath","pea","eat",};
        WordSearchII wsii = new WordSearchII();
        System.out.println(wsii.findWords(board, words));
    }
}
