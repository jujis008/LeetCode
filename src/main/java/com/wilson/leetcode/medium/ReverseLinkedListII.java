package com.wilson.leetcode.medium;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode node = dummy;
    for (int i = 0; i < m - 1; i++) {
      node = node.next;
    }
    ListNode next = node.next, front = next.next;
    for (int i = 0; i < n - m; i++) {
      next.next = front.next;
      front.next = node.next;
      node.next = front;
      front = next.next;
    }
    return dummy.next;
  }

  public void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + "=>");
      head = head.next;
      if (head == null) {
        System.out.print("NULL");
      }
    }
    System.out.println();
  }

  public ListNode insert(ListNode head, int[] vals) {
    ListNode last = null;
    for (int i = 0, len = vals.length; i < len; i++) {
      if (head == null) {
        head = new ListNode(vals[i]);
        last = head;
      } else {
        if (last == null) last = head;
        last.next = new ListNode(vals[i]);
        last = last.next;
      }
    }
    return head;
  }

  class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
    int[] nums = {1, 2, 3, 4, 5};
    ListNode head = null;
    ListNode listNode = reverseLinkedListII.insert(head, nums);
//    reverseLinkedListII.printList(listNode);
    reverseLinkedListII.printList(reverseLinkedListII.reverseBetween(listNode, 2, 4));
  }
}

