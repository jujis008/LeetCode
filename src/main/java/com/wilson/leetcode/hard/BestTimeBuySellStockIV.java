package com.wilson.leetcode.hard;

import java.util.Arrays;

/**
 * DP problem
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 * Created by i324291 on 2018/5/9.
 */
public class BestTimeBuySellStockIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickResolve(prices);
//        System.out.println("k===>" + k);
        int[][] transactions = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int holding = -prices[0];
            for (int j = 1; j < len; j++) {
                transactions[i][j] = Math.max(transactions[i][j - 1], prices[j] + holding);
                holding = Math.max(holding, transactions[i - 1][j - 1] - prices[j]);
//                System.out.print("i= " + i + ", j= " + j + ", t[i][j] = " + transactions[i][j] + " ");
            }
        }
//        System.out.println();
        return transactions[k][len - 1];
    }

    private int quickResolve(int[] prices) {
        int profit = 0;
        for (int i = 1, len = prices.length; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeBuySellStockIV().maxProfit(2, new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new BestTimeBuySellStockIV().maxProfit(2,new int[]{1,2,3,4,5}));
        System.out.println(new BestTimeBuySellStockIV().maxProfit(2, new int[]{7,6,4,3,1}));
        System.out.println(new BestTimeBuySellStockIV().maxProfit(2, new int[]{2,4,1}));
        System.out.println(new BestTimeBuySellStockIV().maxProfit(2, new int[]{3,2,6,5,0,3}));
        System.out.println(new BestTimeBuySellStockIV().maxProfit(2, new int[]{6,1,3,2,4,7}));
    }
}
