package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 * @author i324291
 */
public class RotateList {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k < 1) return head;
    ListNode last = head.next, point, next;
    int n = 1;
    while (last != null) {
      last = last.next;
      n++;
    }
    k %= n;
    if (k == 0) return head;
    point = head;
    for (int i = 0; i < k; i++) {
      point = point.next;
    }
    ListNode tail = head;
    while (point.next != null) {
      tail = tail.next;
      point = point.next;
    }
    ListNode newHead = tail.next;
    tail.next = null;
    point.next = head;
    return newHead;
  }

  public static void main(String[] args) {
    RotateList rl = new RotateList();
    int[] d1 = {1, 2, 3, 4, 5};
    int[] d2 = {0, 1, 2, 3};
//    ListNode head = ListNode.buildListNode(d1);
//    ListNode node = rl.rotateRight(head, 2);
//    ListNode.print(node);
    ListNode head1 = ListNode.buildListNode(d2);
    ListNode node1 = rl.rotateRight(head1, 2);
    ListNode.print(node1);
  }
}
