package com.wilson.leetcode.hard;

import java.util.Arrays;

/**
 * Created by i324291 on 2017/8/22.
 * There are N children standing in a line. Each child is assigned a rating value.

 * You are giving candies to these children subjected to the following requirements:

 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 */
public class Candy {
    /**
     * 1 3 2 4 9 4 3 5 7 5 6
     * 1   1       1     1 = 4
     *   2   2   2   2     2 = 10
     *         3       3 = 6
     * total = 20
     * @param ratings
     * @return
     */
    public int caculateCandy(int[] ratings) {
        int candyCount = 0;
        final int len = ratings.length;
        int[] left2Right = new int[len];
        int[] right2Left = new int[len];
        Arrays.fill(left2Right, 1);
        Arrays.fill(right2Left, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i-1]) {
                left2Right[i] = left2Right[i-1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2Left[i] = right2Left[i + 1] + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            candyCount += Math.max(left2Right[i], right2Left[i]);
        }
        return candyCount;
    }

    /**
     * 1 3 2 4 9 4 3 5 7 5 6
     * 1   1       1     1
     *   2   2   2   2     2
     *         3       3
     * total = 20
     * @param ratings
     * @return
     */
    public int caculateCandy2(int[] ratings) {
        int candyCount = 0;
        final int len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        candyCount = candies[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
            candyCount += candies[i];
        }
        return candyCount;
    }

    public static void main (String[] args) {
        Candy candy = new Candy();
        int[] rating = {1, 3, 2, 4, 9, 4, 3, 5, 7, 5, 6};
        System.out.println(candy.caculateCandy(rating));
        System.out.println(candy.caculateCandy2(rating));
    }
}
