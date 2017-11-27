package com.wilson.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by i324291 on 2017/8/29.
 *
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
 *
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 * You could assume there always exists an answer.
 *
 * Example 1:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"]
 * Explanation: The only restaurant they both like is "Shogun".
 *
 * Example 2:
 * Input:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * Output: ["Shogun"]
 * Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 * Note:
 * The length of both lists will be in the range of [1, 1000].
 * The length of strings in both lists will be in the range of [1, 30].
 * The index is starting from 0 to the list length minus 1.
 * No duplicates in both lists.
 */
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        List<String> ls1 = Arrays.asList(list1);
        List<String> ls2 = Arrays.asList(list2);
        int minLen = Integer.MAX_VALUE;
        for (String str : ls1) {
            int sum;
            if (ls2.contains(str)) {
                sum = ls1.indexOf(str) + ls2.indexOf(str);
                if (sum < minLen) {
                    result.clear();
                    result.add(str);
                    minLen = sum;
                } else if (sum == minLen) {
                    result.add(str);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists twoLists = new MinimumIndexSumOfTwoLists();
        String[] s1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] s2 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] s2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        for(String str : twoLists.findRestaurant(s1, s2)) {
            System.out.println(str);
        }
    }
}
