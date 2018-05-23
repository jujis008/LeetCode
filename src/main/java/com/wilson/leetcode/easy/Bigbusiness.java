package com.wilson.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 题目描述：给出两个数组a，b。a[i]代表第i部影片的版权费，b[i]代表第i部影片能卖的钱，现在本金k，问最后最多能赚多少钱。(每部影片只需要买一次版权，只能卖一次)
 * 思路点拨：可以考虑排序后从小到大开始贪心，当然这里我们只考虑赚钱的影片，亏本的就不要了。
 * Created by i324291 on 2018/4/19.
 */
public class Bigbusiness {
    class Pair implements Comparable<Pair> {
        private int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(Pair pair) {
            return a - pair.a;
        }
    }

    /**
     *
     * @param a cost of the file
     * @param b sell price
     * @param k principal
     * @return
     */
    public int makeMoney(int[] a, int[] b, int k) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0, len = a.length; i < len; i++) {
            list.add(new Pair(a[i], b[i]));
        }
        Collections.sort(list);
        for (Pair pair : list) {
            if (pair.b > pair.a && k >= pair.a) {
                k += pair.b - pair.a;
            }
        }
        return k;
    }
}
