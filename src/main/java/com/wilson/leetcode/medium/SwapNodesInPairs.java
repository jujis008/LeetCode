package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * @author i324291
 */
public class SwapNodesInPairs {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode pre = head, cur = head.next, next;
    while (pre != null && pre.next != null) {
      next = pre.next.next;
      pre.next.next = pre;
      pre.next = (next != null && next.next != null) ? next.next : next;
      pre = next;
    }
    return cur;
  }

  public static void main(String[] args) {
    SwapNodesInPairs snip = new SwapNodesInPairs();
    int[] data = {1, 2, 3, 4};
    ListNode head = ListNode.buildListNode(data);
    ListNode.print(head);

    ListNode node = snip.swapPairs(head);
    ListNode.print(node);
  }
}
