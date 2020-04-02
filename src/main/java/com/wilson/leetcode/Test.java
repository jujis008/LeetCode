package com.wilson.leetcode;

import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by i324291 on 2019/2/25.
 */
public class Test {
//    private static List<String> list = null;
//    private static String dp = "[^\\d\\w\\-|=&.]";
//    static int limit = 6;
//
//    public static String[] elascapeStr(String input) {
//        if (input == null || input.isEmpty()) {
//            return null;
//        }
//        input = input.replaceAll(dp, "");
//        String[] inputs = input.split("&", limit + 1);
//        return inputs;
//    }
//
//    public static void main(String[] args) {
//        final String key1 = "key";
//        Map<String, List<String>> map = new HashMap<>();
//        for (int i=0; i< 5; i++) {
//            if (list == null) {
//                list = new ArrayList<>();
//                map.put(key1, list);
//            } else {
//                list = map.get(key1);
//            }
//            list.add("A");
//        }
//        Set<String> str = new HashSet<>();
//        StringBuilder sb = new StringBuilder();
//        sb.append("ABC").append("$").append("ABCd").append("$").append("ABCe");
//        StringBuilder sb1 = new StringBuilder();
//        sb1.append("ABC").append("$").append("ABCd").append("$").append("ABCe");
//        str.add(sb.toString());
//        str.add(sb1.toString());
//
////        Iterator<String> it = str.iterator();
////        for (;it.hasNext();) {
////            String[] sd = it.next().split("$");
////            for (String s : sd) {
////
////            }
////        }
//        System.out.println(str);
//
//        System.out.println(map.get(key1));
//        System.out.println(new Integer(100000).toString());
//        final String input = "c=ddw|09|23&d=w&u=k&k=2_23&s=3&h2=23&s9=282";
//        final int maxValueLength = 30;
//        String[] ss = elascapeStr(input);
//        System.out.println(ss.length);
//        int length = ss.length > limit ? limit : ss.length;
//        for (int i = 0; i < length; i++) {
//            String keyPair = ss[i];
//            if (nullOrEmptyStr(keyPair)) continue;
//            int idx = keyPair.indexOf('=');
//            if (idx > -1) {
//                String key = keyPair.substring(0, idx);
//                if (nullOrEmptyStr(key)) continue;
//                String val = keyPair.substring(idx + 1);
//                if (nullOrEmptyStr(val)) val = "-";
//                if (val.length() > maxValueLength) val = val.substring(0, maxValueLength);
////                PerfLogFieldLogger.addCustomizedLog(key, val);
//                System.out.println("key= " + key + ", val= " + val);
//            }
//        }
//    }
//
//    static boolean nullOrEmptyStr(String str) {
//        return str == null || str.isEmpty();
//    }
    ThreadLocal<DateFormat> format = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
    public static void main(String[] args) {
        Integer i = 10;
        System.out.println(Integer.toString(i, 3));
        System.out.println(Integer.toString(i, 2));
        Runnable hello = () -> System.out.println("hello world");
        hello.run();
        new JButton().addActionListener((event) -> System.out.println(event.getActionCommand()));
        Stream<String> stream = Stream.of("a", "b", "c").filter((s) -> s.equals("a"));
        System.out.println(stream.count());
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        System.out.println(list);
        System.out.println(Objects.deepEquals(Arrays.asList("a", "b", "c"), list));
        List<String> list1 = Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("list1="+list1);
        List<String> list2 = Stream.of(list, list1).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("list2=" + list2);
        List<Integer> list3 = Stream.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6, 256)).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("list3=" + list3);
        String max = list.stream().max(Comparator.comparing(String::length)).get();
        System.out.println("max=" + max);
        int max1 = list3.stream().reduce((a, b) -> a > b ? a : b).get();
        System.out.println("max1="+max1);
        int sum = list3.stream().reduce(0, (acc, elem) -> acc + elem);
        int sum1 = list3.stream().reduce(0, Integer::sum);
        System.out.println("sum=" + sum);
        System.out.println("sum1=" + sum1);
//        BinaryOperator<Integer> accumulator = (acc, elem) -> acc + elem;
        BinaryOperator<Integer> accumulator = Integer::sum;
        int sum3 = accumulator.apply(accumulator.apply(accumulator.apply(0, 1), 2), 3);
        System.out.println(sum3);
        int s2 = list3.stream().reduce(0, (acc, elem) -> elem * 2);
        System.out.println(s2);
        List<Integer> list4 = list3.stream().map(s -> s * 2).collect(Collectors.toList());
        System.out.println(list4);
    }
}
