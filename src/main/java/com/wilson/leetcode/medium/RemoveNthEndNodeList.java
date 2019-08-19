package com.wilson.leetcode.medium;


/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthEndNodeList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int[] c = {n};
    head = recursiveRemove(head, c);
    return head;
  }

  private ListNode recursiveRemove(ListNode head, int[] n) {
    if (head == null) return null;
    head.next = recursiveRemove(head.next, n);
    n[0]--;
    return n[0] == 0 ? head.next : head;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}