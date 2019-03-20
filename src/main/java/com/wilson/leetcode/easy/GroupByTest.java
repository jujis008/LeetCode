package com.wilson.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by i324291 on 2018/6/4.
 */
public class GroupByTest {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);
    }
}
