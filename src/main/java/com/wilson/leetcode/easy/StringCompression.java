package com.wilson.leetcode.easy;

/**
 * Given an array of characters, compress it in-place.

 The length after compression must always be smaller than or equal to the original array.

 Every element of the array should be a character (not int) of length 1.

 After you are done modifying the input array in-place, return the new length of the array.


 Follow up:
 Could you solve it using only O(1) extra space?


 Example 1:

 Input:
 ["a","a","b","b","c","c","c"]

 Output:
 Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

 Explanation:
 "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".


 Example 2:

 Input:
 ["a"]

 Output:
 Return 1, and the first 1 characters of the input array should be: ["a"]

 Explanation:
 Nothing is replaced.


 Example 3:

 Input:
 ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

 Output:
 Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

 Explanation:
 Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 Notice each digit has it's own entry in the array.


 Note:

 All characters have an ASCII value in [35, 126].
 1 <= len(chars) <= 1000.
 * Created by i324291 on 2019/4/9.
 */
public class StringCompression {
    public int compress1(char[] chars) {
        if (chars.length == 1) return chars.length;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i+1]) {
                count++;
                continue;
            } else {
                sb.append(chars[i]);
                if (count == 1) continue;
                sb.append(count);
                count = 1;
            }
        }
        sb.append(chars[chars.length - 1]);
        if (count != 1) sb.append(count);
        chars = sb.toString().toCharArray();
        System.out.println(chars);
        return sb.length();
    }

    public int compress(char[] chars) {
        int cursor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
                chars[write++] = chars[cursor];
                if (read > cursor) {
                    for (char c : ((read - cursor + 1) + "").toCharArray()) {
                        chars[write++] = c;
                    }
                }
                cursor = read + 1;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        System.out.println(sc.compress(new char[]{'a', 'a', 'a', 'b', 'c', 'c'}));
        System.out.println(sc.compress1(new char[]{'a', 'a', 'a', 'b', 'c', 'c'}));
    }
}
