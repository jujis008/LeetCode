package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

/**
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 *
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.
 *
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.
 *
 * Return a List of ListNode's representing the linked list parts that are formed.
 *
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 * Example 1:
 * Input:
 * root = [1, 2, 3], k = 5
 * Output: [[1],[2],[3],[],[]]
 * Explanation:
 * The input and each element of the output are ListNodes, not arrays.
 * For example, the input root has root.val = 1, root.next.val = 2, \root.next.next.val = 3, and root.next.next.next = null.
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but it's string representation as a ListNode is [].
 * Example 2:
 * Input:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * Explanation:
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * Note:
 *
 * The length of root will be in the range [0, 1000].
 * Each value of a node in the input will be an integer in the range [0, 999].
 * k will be an integer in the range [1, 50]
 *
 * @author i324291
 */
public class SplitLinkedListInParts {
  public ListNode[] splitListToParts(ListNode head, int k) {
    ListNode[] arr = new ListNode[k];
    if (head == null) return arr;
    if (k < 2) {
      arr[0] = head;
      return arr;
    }
    ListNode node = head;
    int len = 0;
    while (node != null) {
      len++;
      node = node.next;
    }
    if (len <= k) {
      int c = 0;
      ListNode n = head, tmp, next;
      while (n != null) {
        next = n.next;
        tmp = n;
        tmp.next = null;
        arr[c++] = tmp;
        n = next;
      }
      while (c < k) {
        arr[c] = null;
        c++;
      }
    } else {
      int avg = len/k;
      int mod = len%k;
      int c = 1;
      ListNode n = head, next;
      int i = 0;
      while (n != null) {
        if (c < avg) {
          c++;
          n = n.next;
        } else {
          if (mod-- > 0) {
            n = n.next;
          }
          next = n.next;
          n.next = null;
          arr[i++] = head;
          c = 1;
          n = next;
          head = next;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    SplitLinkedListInParts sllip = new SplitLinkedListInParts();
    int[] d = {1, 2, 3};
    int[] d1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    ListNode head = ListNode.buildListNode(d1);
    ListNode[] arr = sllip.splitListToParts(head, 3);
    for (ListNode a : arr) {
      ListNode.print(a);
    }
  }
}
