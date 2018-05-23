package com.wilson.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述：
 * 给出一个字符串str，找到最长重复不小于k次的子串，输出长度，子串可以有重叠部分，但不能完全重叠。
 *
 * 思路点拨：
 * 可以通过枚举子串+hash的方法做到O(n^2)，当然如果用算法竞赛中的后缀数组+二分答案可做到O(nlogn)。
 *
 * 考点分析：
 * 枚举子串计数很容易想到，不过能想到用hash优化字符串比较那一步就能将复杂度降一个维度。这里做hash需要边枚举边hash。
 * Created by i324291 on 2018/4/19.
 */
public class LongestRepeatingSubstring {
//    private int answer;
//    class Edge {
//        private int v;
//        private int cost;
//
//        public Edge(int v, int cost) {
//            this.v = v;
//            this.cost = cost;
//        }
//    }
//
//    public void dfs(int x, int value, int parent, int[] profits, List<List<Edge>> g) {
//        int isLeaf = 1;
//        value += profits[x];
//        for (Edge edge : g.get(x)) {
//            if (edge.v != parent) {
//                dfs(edge.v, value - edge.cost, x, profits, g);
//                isLeaf = 0;
//            }
//        }
//        if (isLeaf == 1) {
//            answer = Math.max(answer, value);
//        }
//    }
//
//    public int getMaxScore(int[] x, int[] y, int[] costs, int[] profits) {
//        List<List<Edge>> g = new ArrayList<>();
//        for (int i = 0, len = x.length; i <= len; i++) {
//            g.add(new ArrayList<>());
//        }
//        for (int i = 0, len = x.length; i < len; i++) {
//            g.get(x[i]).add(new Edge(y[i], costs[i]));
//            g.get(y[i]).add(new Edge(x[i], costs[i]));
//        }
//        answer = Integer.MIN_VALUE;
//        dfs(0, 0, 0, profits, g);
//        return answer;
//    }
    public int resolve(String str, int k) {
        int maxLength = 0;
        Map<Long, Integer> map = new HashMap<>();
        long seed = 2 << 5-1;
        long mod = 100000000007L;
        for(int i = 0, len = str.length(); i < len; i++) {
            long hash = 0L;
            for (int j = i; j < len; j++) {
                hash = (seed * hash + str.charAt(j) - 'a' + 1) % mod;
                if (map.containsKey(hash)) {
                    map.put(hash, map.get(hash) + 1);
                } else {
                    map.put(hash, 1);
                }
            }
        }
        for (int i = 0, len = str.length(); i < len; i++) {
            long hash = 0L;
            for (int j = i; j < len; j++) {
                hash = (seed * hash + str.charAt(j) - 'a' + 1) % mod;
                if (map.get(hash) >= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestRepeatingSubstring lrs = new LongestRepeatingSubstring();
        String str = "gegg(x[i]).add(new Edge(y[i], costs[i]));";
        System.out.println(lrs.resolve(str, 5));
    }
}
