package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * Example 1:
 *
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 *
 * Input: 1->1->1->2->3
 * Output: 2->3
 * @author i324291
 */
public class RemoveDuplicatesFromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummy = new ListNode(~(head.val));
    dummy.next = head;
    head = dummy;
    ListNode fast = head, slow = head;
    while (fast.next != null) {
      if (fast.val == fast.next.val && fast.next.next == null) {
        slow.next = null;
      } else if (fast.val != fast.next.val && fast.next.next == null) {
        slow.next = fast.next;
      } else if (fast.val != fast.next.val && fast.next.next.val != fast.next.val) {
        slow.next = fast.next;
        slow = slow.next;
      }
      fast = fast.next;
    }
    return head.next;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
    int[] d1 = {1, 2, 2, 3};
    ListNode node = ListNode.buildListNode(d1);
    ListNode.print(node);
    ListNode n1 = r.deleteDuplicates(node);
    ListNode.print(n1);
  }
}
