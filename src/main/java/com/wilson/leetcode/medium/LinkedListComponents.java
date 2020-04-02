package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * We are given head, the head node of a linked list containing unique integer values.
 *
 * We are also given the list G, a subset of the values in the linked list.
 *
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 *
 * Example 1:
 *
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 *
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * Note:
 *
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 *
 * @author i324291
 */
public class LinkedListComponents {
  public int numComponents(ListNode head, int[] g) {
    Set<Integer> set = new HashSet<>();
    int len = g.length;
    if (head == null || head.next == null || len == 0) return 0;
    for (int i : g) set.add(i);
    boolean contains = false;
    int count = 0;
    ListNode pre = head;
    while (pre != null) {
      if (set.contains(pre.val)) {
        if (!contains) {
          contains = true;
          count++;
        }
      } else {
        contains = false;
      }
      pre = pre.next;
    }
    return count;
  }

  public void delete(int[] g, int x) {
    for(int i = 0, len = g.length; i < len; i++) {
      if (g[i] == x) {
        System.arraycopy(g, i + 1, g, i, len - 1);
        len -= 1;
      }
    }
  }

  public boolean exists(int[] g, int x) {
    for (int i : g) {
      if (x == i) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    LinkedListComponents llc = new LinkedListComponents();
    int[] d = {0, 1, 2, 3};
    int[] g = {0, 1, 3};
    ListNode head = ListNode.buildListNode(d);
    int c = llc.numComponents(head, g);
    System.out.println(c);
  }
}
