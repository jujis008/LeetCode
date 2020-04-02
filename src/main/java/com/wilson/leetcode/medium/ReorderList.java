package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
 * @author i324291
 */
public class ReorderList {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode pre = head;
    ListNode mid = findMid(head);
    ListNode cur = reverse(mid);
    ListNode temp;
    while (pre.next != null) {
      temp = pre.next;
      pre.next = cur;
      pre = temp;

      temp = cur.next;
      cur.next = pre;
      cur = temp;
    }
    pre.next = cur;
  }

  public ListNode findMid(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode slow = head, fast = head, slowPre = head;
    while (fast != null && fast.next != null) {
      slowPre = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    slowPre.next = null;
    return slow;
  }

  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode pre = head, cur = head.next, next;
    pre.next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public static void main(String[] args) {
    ReorderList rl = new ReorderList();
    int[] d = {1, 2, 3, 4};
    ListNode head = ListNode.buildListNode(d);
    rl.reorderList(head);
    ListNode.print(head);
  }
}
