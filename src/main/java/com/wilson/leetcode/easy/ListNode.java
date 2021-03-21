package com.wilson.leetcode.easy;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode buildListNode(int[] data) {
    if (data == null || data.length == 0) return null;
    ListNode head = new ListNode(0);
    head.next = null;
    ListNode tmp, cur = head;
    for (int d : data) {
      tmp = new ListNode(d);
      tmp.next = null;
      cur.next = tmp;
      cur = tmp;
    }
    return head.next;
  }

  public static void print(ListNode head) {
    if (head == null) return;
    ListNode node = head;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
    System.out.println();
  }
}
