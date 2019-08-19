package com.wilson.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 1.     1
 2.     11
 3.     21
 4.     1211
 5.     111221
 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

 Note: Each term of the sequence of integers will be represented as a string.

 Example 1:
 Input: 1
 Output: "1"

 Example 2:
 Input: 4
 Output: "1211"

 Example 3:
 Input: 6
 Output: "312211"

 Example 4:
 Input: 7
 Output: "312221"
 * Created by i324291 on 2019/4/8.
 */
public class CountAndSay {
    private Map<Integer, String> cache = new HashMap<>();
    public String countAndSay(int num) {
        if (num == 1) return "1";
        String val = cache.get(num - 1);
        if (val == null || val.isEmpty()) {
            val = countAndSay(num - 1);
            cache.put(num - 1, val);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length(); i++) {
            int count = 1;
            while (i < val.length() - 1 && val.charAt(i) == val.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(val.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(1));
        System.out.println(cas.countAndSay(4));
        System.out.println(cas.countAndSay(25));
        System.out.println(cas.countAndSay(26));
    }

}
