package com.wilson.leetcode.hard;

/**
 * DP problem
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Created by i324291 on 2018/5/9.
 */
public class BestTimeBuySellStockIII {
    public int maxProfit(int[] prices) {
        int profit = 0,
            maxProfitOnlyOneTran = 0,
            minPrice = Integer.MAX_VALUE,
            maxProfitAfterSecondBuy = Integer.MIN_VALUE;
        for (int curPrice : prices) {
            profit = Math.max(profit, maxProfitAfterSecondBuy + curPrice);
            maxProfitAfterSecondBuy = Math.max(maxProfitAfterSecondBuy, maxProfitOnlyOneTran - curPrice);
            maxProfitOnlyOneTran = Math.max(maxProfitOnlyOneTran, curPrice - minPrice);
            minPrice = Math.min(minPrice, curPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeBuySellStockIII().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new BestTimeBuySellStockIII().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new BestTimeBuySellStockIII().maxProfit(new int[]{7,6,4,3,1}));
    }
}
