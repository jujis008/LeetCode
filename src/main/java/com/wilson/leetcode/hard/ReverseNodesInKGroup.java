package com.wilson.leetcode.hard;

import com.wilson.leetcode.easy.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * @author i324291
 */
public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k < 2) return head;
    ListNode pre = null, begin = head, end, next;
    int i = 1;
    while (begin != null) {
      end = begin;
      for (; i < k; i++) {
        if (end.next != null) end = end.next;
        else break;
      }
      next = end.next;
      end.next = null;
      if (i < k) {
        if (pre == null) {
          pre = begin;
          head = pre;
        } else {
          pre.next = begin;
        }
        return head;
      }
      ListNode reversed = reverse(begin);
      ListNode.print(reversed);
      if (pre == null){
        pre = reversed;
        head = pre;
      } else {
        pre.next = reversed;
      }
      begin.next = next;
      pre = begin;
      begin = next;
      i = 1;
    }
    return head;
  }

  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode pre = head, cur = pre.next, next;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    head.next = null;
    head = pre;
    return head;
  }

  public static void main(String[] args) {
    ReverseNodesInKGroup rnikg = new ReverseNodesInKGroup();
    int[] data = {1, 2, 3, 4};
    ListNode head = ListNode.buildListNode(data);
//    ListNode node = rnikg.reverse(head);
//    ListNode.print(node);
    ListNode n1 = rnikg.reverseKGroup(head, 3);
    ListNode.print(n1);
//    ListNode n2 = rnikg.reverseKGroup(head, 2);
//    ListNode.print(n2);
  }
}
