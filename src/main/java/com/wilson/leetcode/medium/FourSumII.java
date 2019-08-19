package com.wilson.leetcode.medium;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such     that A[i] + B[j] + C[k] + D[l] is zero.

    To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

    Example:

    Input:
    A = [ 1, 2]
    B = [-2,-1]
    C = [-1, 2]
    D = [ 0, 2]

    Output:
    2

    Explanation:
    The two tuples are:
    1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 */
public class FourSumII {
//  private List<List<Integer>> result;
//  public List<List<Integer>> fourSum(int[] nums, int target) {
//    return nSum(nums, target, 4);
//  }
//
//  public List<List<Integer>> nSum(int[] nums, int target, int n) {
//    result = new ArrayList<>();
//    Arrays.sort(nums);
//    helper(nums, 0, target, n, new Integer[n]);
//    return result;
//  }
//
//  public void helper(int[] nums, int start, int target, int count, Integer[] arr) {
//    if (count == 0) {
//      if (target == 0) {
//        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
//        result.add(list);
//      }
//      return;
//    }
//    if (count == 2) {
//      twoSum(nums, start, target, arr);
//      return;
//    }
//    int last = Integer.MAX_VALUE;
//    for (int i = start, len = nums.length; i < len; i++) {
//      if (nums[i] != last) {
//        last = nums[i];
//        arr[arr.length - count] = nums[i];
//        helper(nums, i + 1, target - nums[i], count - 1, arr);
//      }
//    }
//  }
//
//  public void twoSum(int[] nums, int start, int target, Integer[] arr) {
//    int lastMin = Integer.MIN_VALUE;
//    int lastMax = Integer.MAX_VALUE;
//    int i = start;
//    int j = nums.length - 1;
//    while(i < j) {
//      if (nums[i] + nums[j] == target) {
//        arr[arr.length - 2] = nums[i];
//        arr[arr.length - 1] = nums[j];
//        result.add(new ArrayList<>(Arrays.asList(arr)));
//        lastMin = nums[i];
//        lastMax = nums[j];
//        i++;
//        j--;
//      } else if (nums[i]+nums[j] > target) {
//        lastMax = nums[j];
//        j--;
//      } else {
//        lastMin = nums[i];
//        i++;
//      }
//      while(i < j && nums[i] == lastMin) {
//        i++;
//      }
//      while(i < j && nums[j] == lastMax) {
//        j--;
//      }
//    }
//  }
//
  public <T> T[] concat(T[] first, T[]...rest) {
    int length = first.length;
    for (T[] array : rest) {
      length += array.length;
    }
    T[] result = Arrays.copyOf(first, length);
    int offset = first.length;
    for(T[] array : rest) {
      System.arraycopy(array, 0, result, offset, array.length);
      offset += array.length;
    }
    return result;
  }
//
//  public <T> boolean exist(List<T> list, T[]...arrays) {
//    for(T[] ts : arrays) {
//      for (T t: ts) {
//        if (list.contains(t)) {
//          list.remove(t);
//          break;
//        }
//      }
//    }
//    return list.size() == 0;
//  }

  public int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
    int count = 0;
    int aLen = a.length;
    int bLen = b.length;
    int cLen = c.length;
    int dLen = d.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < aLen; i++) {
      for (int j = 0; j < bLen; j++) {
        int sum1 = a[i] + b[j];
        if (map.containsKey(sum1)) {
          int val = map.get(sum1);
          map.put(sum1, val+1);
        } else {
          map.put(sum1, 1);
        }
      }
    }
    for (int i = 0; i < cLen; i++) {
      for (int j = 0; j < dLen; j++) {
        int sum2 = c[i] + d[j];
        if (map.containsKey(-sum2)) {
          count += map.get(-sum2);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    FourSumII fourSumII = new FourSumII();
    int[] a = {1, 2};
    int[] b = {-2,-1};
    int[] c = {-1, 2};
    int[] d = {0, 2};

    int[] a1 = {-1,-1};
    int[] b1 = {-1,1};
    int[] c1 = {-1,1};
    int[] d1 = {1,-1};
    System.out.println(fourSumII.fourSumCount(a, b, c, d));
    System.out.println(fourSumII.fourSumCount(a1, b1, c1, d1));
  }
}