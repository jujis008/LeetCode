package com.wilson.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * In a list of songs, the i-th song has a duration of time[i] seconds.

 Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

 Example 1:

 Input: [30,20,150,100,40]
 Output: 3
 Explanation: Three pairs have a total duration divisible by 60:
 (time[0] = 30, time[2] = 150): total duration 180
 (time[1] = 20, time[3] = 100): total duration 120
 (time[1] = 20, time[4] = 40): total duration 60
 Example 2:

 Input: [60,60,60]
 Output: 3
 Explanation: All three pairs have a total duration of 120, which is divisible by 60.

 Note:

 1 <= time.length <= 60000
 1 <= time[i] <= 500
 * Created by i324291 on 2019/4/2.
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] times) {
        if (times.length < 2) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int mod = times[i] % 60;
            if (map.containsKey(60 - mod)) {
                count += map.get(60 - mod);
            } else if (!map.containsKey(mod)) {
                map.put(mod, 1);
            } else {
                map.put(mod, map.get(mod) + 1);
            }
        }
        if (map.containsKey(0)) {
            int mod = map.get(0);
            return count + (mod - 1) * mod / 2;
        }
        return count;
    }

    public int numPairsDivisibleBy601(int[] times) {
        int[] counts = new int[60];
        int count = 0;
        for (int time : times) {
            count += counts[(60 - time % 60) % 60];
            counts[time % 60] += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        PairsOfSongsWithTotalDurationsDivisibleBy60 poswtddb = new PairsOfSongsWithTotalDurationsDivisibleBy60();
        System.out.println(poswtddb.numPairsDivisibleBy601(new int[]{30,20,150,100,40}));
        System.out.println(poswtddb.numPairsDivisibleBy601(new int[]{60,60,60}));
    }
}
