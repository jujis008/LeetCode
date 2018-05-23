package com.wilson.leetcode.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Created by i324291 on 2018/5/9.
 */
public class BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxPrice = 0, profit = 0;
        for (int i = 1, len = prices.length; i < len; i++) {
            if (minPrice > prices[i-1]) {
                minPrice = prices[i-1];
                maxPrice = prices[i];
            }
            if (maxPrice < prices[i]) {
                maxPrice = prices[i];
            }
            profit = Math.max(profit, maxPrice - minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeBuySellStock().maxProfit(new int[]{3,2,6,5,0,3}));
        System.out.println(new BestTimeBuySellStock().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new BestTimeBuySellStock().maxProfit(new int[]{}));
    }
}
