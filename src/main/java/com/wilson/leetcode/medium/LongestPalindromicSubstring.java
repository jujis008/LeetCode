package com.wilson.leetcode.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb
 * Created by i324291 on 2018/11/5.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2 || isPalindrome2(s)) return s;
        for (int i = 1; i < len; i++) {
            int start = 0;
            int end = len - i;
            while (start <= i) {
                String result = s.substring(start, end);
                if (isPalindrome2(result)) return result;
                else {
                    start++;
                    end++;
                }
            }
        }
        return s.substring(0, 1);

    }

    public boolean isPalindrome(String s) {
        final int len = s.length();
        if (len > 1) {
            String part1 = s.substring(0, len/2);
            StringBuilder sb;
            if (len % 2 == 0) {
                sb = new StringBuilder(s.substring(len / 2, len));
            } else {
                sb = new StringBuilder(s.substring(len / 2 + 1, len));
            }
            return part1.equals(sb.reverse().toString());
        }
        return false;
    }

    public boolean isPalindrome2(String s) {
        final int len = s.length();
        if (len > 1) {
            int start2;
            if (len % 2 == 0) {
                start2 = len/2;
            } else {
                start2 = len / 2 + 1;
            }
            char[] ar1 = s.substring(0, len/2).toCharArray();
            char[] ar2 = s.toCharArray();
            for (int i = 0, j = len - 1; i < len/2 && j >= start2; i++, j--) {
                if (ar1[i] != ar2[j]) return false;
            }
            return true;
        }
        return false;
    }

    public String manacherAlgorithm(String src) {
        if (src == null || src.length() == 0) return "";
        String target = preHandle(src);
        char[] targets = target.toCharArray();
        int len = target.length();
        int mid = 0, right = 0;
        int[] p = new int[len];
        int maxLen = 0, curIndex = 0;
        for (int i = 1; i < len; i++) {
            int left = 2 * mid - i;
            p[i] = right > i ? Math.min(right - i, p[left]) : 0;
            while ( i + p[i] < len && i >= p[i] && targets[i + p[i]] == targets[i - p[i]]) {
                ++p[i];
            }
            if (i + p[i] > right) {
                mid = i;
                right = i + p[i];
            }
            if (p[i] > maxLen) {
                maxLen = p[i];
                curIndex = i;
            }
        }
        System.out.println("src= " + src.length() + " curIndex= " + curIndex + ", maxLen= " + maxLen);
        final int startIdx = (curIndex - maxLen + 1)/2;
        System.out.println("startIdx= " + startIdx + ", src= " + src);
        for (int c : p) {
            System.out.print(c + ", ");
        }
        System.out.println();
        return src.substring(startIdx, startIdx + maxLen - 1);
    }

    private String preHandle(String src) {
        StringBuilder target = new StringBuilder(src);
        for (int i = 0, len = 2 * src.length(); i < len; i+=2) {
            target.insert(i, '#');
        }
        target.append("#");
        return target.toString();
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring instance = new LongestPalindromicSubstring();
        String s = "jhgtrclvzumufurdemsogfkpzcwgyepdwucnxrsubrxadnenhvjyglxnhowncsubvdtftccomjufwhjupcuuvelblcdnuchuppqpcujernplvmombpdttfjowcujvxknzbwmdedjydxvwykbbamfnsyzcozlixdgoliddoejurusnrcdbqkfdxsoxxzlhgyiprujvvwgqlzredkwahexewlnvqcwfyahjpeiucnhsdhnxtgizgpqphunlgikogmsffexaeftzhblpdxrxgsmeascmqngmwbotycbjmwrngemxpfakrwcdndanouyhnnrygvntrhcuxgvpgjafijlrewfhqrguwhdepwlxvrakyqgstoyruyzohlvvdhvqmzdsnbtlwctetwyrhhktkhhobsojiyuydknvtxmjewvssegrtmshxuvzcbrabntjqulxkjazrsgbpqnrsxqflvbvzywzetrmoydodrrhnhdzlajzvnkrcylkfmsdode";
        String s1 = "lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
        String s2 = "babad";
//        String s1 = "abb";
        long start = System.currentTimeMillis();
        System.out.println(instance.longestPalindrome(s));
        System.out.println(instance.longestPalindrome(s1));
//        System.out.println(System.currentTimeMillis() - start);
        System.out.println(instance.preHandle(s));
        System.out.println(instance.manacherAlgorithm(s));
        System.out.println(instance.manacherAlgorithm(s1));
        System.out.println(instance.manacherAlgorithm(s2));

    }
}
