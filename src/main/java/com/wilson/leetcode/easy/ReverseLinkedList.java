package com.wilson.leetcode.easy;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode node = dummy;
    ListNode counter = head;
    int length = 0;
    while (counter != null) {
      counter = counter.next;
      length++;
    }
    ListNode next = node.next, front = next.next;
    for (int i = 0; i < length - 1; i++) {
      next.next = front.next;
      front.next = node.next;
      node.next = front;
      front = next.next;
    }
    return dummy.next;
  }

  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode node = new ListNode(0);
    node.next = head;
    ListNode p = node.next, q = p.next;
    while (q != null) {
      p.next = q.next;
      q.next = node.next;
      node.next = q;
      q = p.next;
    }
    return node.next;
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
    ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
    int[] nums = {1, 2, 3, 4, 5};
    ListNode head = null;
    ListNode listNode = reverseLinkedList.insert(head, nums);
//    reverseLinkedListII.printList(listNode);
//    reverseLinkedList.printList(reverseLinkedList.reverseList(listNode));
    reverseLinkedList.printList(reverseLinkedList.reverseList2(listNode));
  }
}

