package com.wilson.leetcode.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * All given inputs are in lowercase letters a-z.
 * Created by i324291 on 2019/3/21.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        final int len = strs.length;
        for (int i = 1; i < len; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        final int len = strs.length;
        final int length = prefix.length();
        for (int i = 0; i < length; i++) {
            char ch = prefix.charAt(i);
            for (int j = 1; j < len; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) return prefix.substring(0, i);
            }
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix2(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix2(String[] strs, int left, int right) {
        if (left == right) return strs[left];
        int mid = (left + right) / 2;
        System.out.println(left + "> " + right + "> " + mid);
        String lcpLeft = longestCommonPrefix2(strs, 1, mid);
        String lcpRight = longestCommonPrefix2(strs, mid + 1, right);
        System.out.println("lcpLeft: " + lcpLeft + ", lcpRight: " + lcpRight);
        return commonPrefix(lcpLeft, lcpRight);
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int minLen = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLen; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) return lcpLeft.substring(0, i);
        }
        return lcpLeft.substring(0, minLen);
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (minLen > strs[i].length()) minLen = strs[i].length();
        }
        int low = 1, high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str)) return false;
        }
        return true;
    }

    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Tree tree = new Tree();
        for (int i = 1; i < strs.length; i++) {
            tree.insert(strs[i]);
        }
        return tree.searchLongestPrefix(strs[0]);
    }

    class TreeNode {
        private TreeNode[] links;
        private final int R = 26;
        private boolean isEnd;
        private int size;

        public TreeNode() {
            links = new TreeNode[R];
        }

        public void put(char ch, TreeNode node) {
            links[ch - 'a'] = node;
            size++;
        }

        public int getLinks() {
            return size;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TreeNode get(char ch) {
            return links[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Tree {
        private TreeNode root;

        public Tree() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new TreeNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        private String searchLongestPrefix(String word) {
            TreeNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.containsKey(ch) && (node.getLinks() == 1) && (!node.isEnd())) {
                    prefix.append(ch);
                    node = node.get(ch);
                } else return prefix.toString();
            }
            return prefix.toString();
        }
    }


    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(lcp.longestCommonPrefix1(new String[]{"flower","flow","flight"}));
        System.out.println(lcp.longestCommonPrefix2(new String[]{"flower","flow","flight"}));
        System.out.println(lcp.longestCommonPrefix2(new String[]{"a","b"}));
        System.out.println(lcp.longestCommonPrefix3(new String[]{"flower","flow","flight"}));
        System.out.println(lcp.longestCommonPrefix4(new String[]{"flower","flow","flight"}));
    }
}
