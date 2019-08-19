package com.wilson.leetcode;

import java.util.*;

/**
 * Created by i324291 on 2019/2/25.
 */
public class Test {
    private static List<String> list = null;
    private static String dp = "[^\\d\\w\\-|=&.]";
    static int limit = 6;

    public static String[] elascapeStr(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        input = input.replaceAll(dp, "");
        String[] inputs = input.split("&", limit + 1);
        return inputs;
    }

    public static void main(String[] args) {
        final String key1 = "key";
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i< 5; i++) {
            if (list == null) {
                list = new ArrayList<>();
                map.put(key1, list);
            } else {
                list = map.get(key1);
            }
            list.add("A");
        }
        Set<String> str = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append("ABC").append("$").append("ABCd").append("$").append("ABCe");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("ABC").append("$").append("ABCd").append("$").append("ABCe");
        str.add(sb.toString());
        str.add(sb1.toString());

//        Iterator<String> it = str.iterator();
//        for (;it.hasNext();) {
//            String[] sd = it.next().split("$");
//            for (String s : sd) {
//
//            }
//        }
        System.out.println(str);

        System.out.println(map.get(key1));
        System.out.println(new Integer(100000).toString());
        final String input = "c=ddw|09|23&d=w&u=k&k=2_23&s=3&h2=23&s9=282";
        final int maxValueLength = 30;
        String[] ss = elascapeStr(input);
        System.out.println(ss.length);
        int length = ss.length > limit ? limit : ss.length;
        for (int i = 0; i < length; i++) {
            String keyPair = ss[i];
            if (nullOrEmptyStr(keyPair)) continue;
            int idx = keyPair.indexOf('=');
            if (idx > -1) {
                String key = keyPair.substring(0, idx);
                if (nullOrEmptyStr(key)) continue;
                String val = keyPair.substring(idx + 1);
                if (nullOrEmptyStr(val)) val = "-";
                if (val.length() > maxValueLength) val = val.substring(0, maxValueLength);
//                PerfLogFieldLogger.addCustomizedLog(key, val);
                System.out.println("key= " + key + ", val= " + val);
            }
        }
    }

    static boolean nullOrEmptyStr(String str) {
        return str == null || str.isEmpty();
    }
}
