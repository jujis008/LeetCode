package com.wilson.leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/advantage-shuffle/
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 * Example 1:
 *
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 *
 * Example 2:
 *
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 */
public class AdvantageShuffle {
  public int[] advantageCount(int[] a, int[] b) {
    final int len = a.length;
    int[] result = new int[len];
    Queue<Integer> ori = new PriorityQueue<>((i, j) -> a[j] - a[i]);
    Queue<Integer> target = new PriorityQueue<>((i, j) -> b[j] - b[i]);
    System.out.println("ori: " + ori);
    System.out.println("target: " + target);
    for (int i = 0; i < len; i++) {
      ori.add(i);
      target.add(i);
    }
    Set<Integer> nonAdvantageIndices = new HashSet<>();
    while (!target.isEmpty()) {
      if (a[ori.peek()] > b[target.peek()]) {
        result[target.poll()] = a[ori.poll()];
      } else {
        nonAdvantageIndices.add(target.poll());
      }
    }
    nonAdvantageIndices.forEach(i -> result[i] = a[ori.poll()]);
    return result;
  }

  public int[] advantageCount1(int[] a, int[] b) {
    final int len = a.length;
    Arrays.sort(a);
    Arrays.sort(b);
    return new int[len];
  }

  public static void main(String[] args) {
    AdvantageShuffle af = new AdvantageShuffle();
//    int[] a = {2,7,11,15};
//    int[] b = {1,10,4,11};
//    System.out.println(Arrays.toString(af.advantageCount(a, b)));
    int[] a1 = {12,24,8,32};
    int[] b1 = {13,25,32,11};
    System.out.println(Arrays.toString(af.advantageCount(a1, b1)));
  }
}
