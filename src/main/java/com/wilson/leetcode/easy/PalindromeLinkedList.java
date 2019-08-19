package com.wilson.leetcode.easy;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

  public boolean isPalindrome1(ListNode head) {
    if (head == null || head.next == null) return true;
    Stack<Integer> stack = new Stack<>();
    ListNode temp = head;
    ListNode node = new ListNode(0);
    node.val = head.val;
    stack.push(head.val);
    ListNode temp1 = node;
    node.next = head;
    while (head.next != null) {
      int val = head.next.val;
      node.next = new ListNode(val);
      node = node.next;
      head = head.next;
      stack.push(val);
    }
    head = temp;
    while (head != null) {
      if (head.val != stack.pop()) return false;
      head = head.next;
    }
    return true;
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    ListNode temp = head;
    ListNode node = new ListNode(0);
    node.val = head.val;
    ListNode temp1 = node;
    node.next = head;
    while (head.next != null) {
      node.next = new ListNode(head.next.val);
      node = node.next;
      head = head.next;
    }
    head = temp;
    node = temp1;
    ListNode tail = reverseList(head);
    while (tail != null) {
      if (tail.val != node.val) {
        return false;
      }
      tail = tail.next;
      node = node.next;
    }
    return true;
  }

  private ListNode reverseList(ListNode head) {
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

  public static void main(String[] args) {
    PalindromeLinkedList pll = new PalindromeLinkedList();
    int[] nums = {1, 2, 3, 4, 5};
    int[] nums1 = {1, 2, 3, 2, 1};
    ListNode head1 = null;
    ListNode head2 = null;
    ListNode listNode = pll.insert(head1, nums);
    ListNode listNode2 = pll.insert(head2, nums1);
    pll.printList(head1);
    pll.printList(head2);
    System.out.println(pll.isPalindrome1(listNode));
    System.out.println(pll.isPalindrome1(listNode2));
  }

  class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
      this.val = val;
    }
  }
}
