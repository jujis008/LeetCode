package com.wilson.leetcode.easy;

/**
 *
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Note: For the purpose of this problem, we define empty string as valid palindrome.

 Example 1:

 Input: "A man, a plan, a canal: Panama"
 Output: true
 Example 2:

 Input: "race a car"
 Output: false
 */
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    String trimed = s.replaceAll("[\\W+ ]", "").toLowerCase();
    StringBuilder sb = new StringBuilder(trimed);
    return trimed.equals(sb.reverse().toString());
  }

  public boolean isPalindrome1(String s) {
    if (s.isEmpty()) return true;
    char[] chs = s.toLowerCase().toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0, len = chs.length; i < len; i++) {
      if ((chs[i] >= 'a' && chs[i] <= 'z') || (chs[i] >= '0' && chs[i] <= '9')) {
        sb.append(chs[i]);
      }
    }
    int length = sb.length();
    for (int i = 0; i < length / 2; i++) {
      if (sb.charAt(i) != sb.charAt(length - 1 - i)) return false;
    }
    return true;
  }

  public boolean isPalindrome2(String s) {
    if (s.isEmpty()) return true;
    int i = 0, len = s.length() - 1;
    char[] chs = s.toCharArray();
    while (i < len) {
      if (chs[i] >= 'A' && chs[i] <= 'Z') chs[i] += 'a'-'A';
      if (chs[len] >= 'A' && chs[len] <= 'Z') chs[len] += 'a'-'A';
      if (!(chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= '0' && chs[i] <= '9')) {
        i++;
        continue;
      }
      if (!(chs[len] >= 'a' && chs[len] <= 'z' || chs[len] >= '0' && chs[len] <= '9')) {
        len--;
        continue;
      }
      if (chs[i] != chs[len]) return false;
      i++;
      len--;
    }
    return true;
  }

  public static void main(String[] args) {
    final String s1 = "A man, a plan, a canal: Panama";
    ValidPalindrome vp = new ValidPalindrome();
//    System.out.println(vp.isPalindrome(s1));
    System.out.println(vp.isPalindrome2(s1));
    final String s2 = "race a car";
//    System.out.println(vp.isPalindrome(s2));
    System.out.println(vp.isPalindrome2(s2));
    final String s3 = "0P";
    System.out.println(vp.isPalindrome2(s3));
  }
}
