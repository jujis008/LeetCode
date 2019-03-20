package com.wilson.leetcode;

import java.util.*;

/**
 * Created by i324291 on 2019/2/25.
 */
public class Test {
    private static List<String> list = null;

    public static void main(String[] args) {
        final String key = "key";
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i< 5; i++) {
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            } else {
                list = map.get(key);
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

        Iterator<String> it = str.iterator();
        for (;it.hasNext();) {
            String[] sd = it.next().split("$");
            for (String s : sd) {

            }
        }
        System.out.println(str);

        System.out.println(map.get(key));
        System.out.println(new Integer(100000).toString());
    }
}
