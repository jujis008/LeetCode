package com.wilson.leetcode.easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 * @author i324291
 */
public class RemoveDuplicatesFromSortedList {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode node = head;
    while (node.next != null) {
      if (node.val == node.next.val) {
        node.next = node.next.next;
      } else {
        node = node.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
    int[] d1 = {1, 1, 2};
    int[] d2 = {1, 1, 2, 3, 3};
    ListNode n1 = ListNode.buildListNode(d1);
    ListNode res1 = r.deleteDuplicates(n1);
    ListNode.print(res1);
    ListNode n2 = ListNode.buildListNode(d2);
    ListNode res2 = r.deleteDuplicates(n2);
    ListNode.print(res2);
  }
}
