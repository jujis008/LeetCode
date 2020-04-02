package com.wilson.leetcode.hard;

import java.util.Arrays;

/**
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 1, 5, 6, 98, 99 --> 6
 * 2, 4, 7  --> 4
 * 2, 4, 5, 98, 99 ==> 5
 * 1, 2, 4, 5, 6, 7, 98, 99
 * 1, 2, 4, 5, 6 ==> 4
 * The median is (2 + 3)/2 = 2.5
 * len1 > len2
 * md1 = 3, md2 = 6
 * https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
 * Created by i324291 on 2018/4/2.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 > len2) { //to ensure m<=n
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmpLen = len1;
            len1 = len2;
            len2 = tmpLen;
        }
        int min = 0, max = len1, halfLen = (len1 + len2 + 1) / 2;
        while (min <= max) {
            int i = (max + min) / 2;
            int j = halfLen - i;
            if (i < max && nums2[j - 1] > nums1[i]) { //i is too small
                min += 1;
            } else if (i > min && nums1[i - 1] > nums2[j]) { // i is too big
                max -= 1;
            } else {
                int maxLeft, minRight;
                if (i == 0) maxLeft = nums2[j - 1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                if ((len1 + len2) % 2 != 0) return maxLeft;


                if (i == len1) minRight = nums2[j];
                else if (j == len2) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2.0d;
            }
        }
        return 0d;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays mtsa = new MedianOfTwoSortedArrays();
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(mtsa.findMedianSortedArrays(nums1, nums2));
    }
}
