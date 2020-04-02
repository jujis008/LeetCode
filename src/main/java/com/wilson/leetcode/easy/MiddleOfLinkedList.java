package com.wilson.leetcode.easy;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * @author i324291
 */
public class MiddleOfLinkedList {
  public ListNode middleNode1(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode node = head, begin = head, next;
    int len = 0;
    while (node != null) {
      len++;
      node = node.next;
    }
    for (int i = 0; i < len/2 - 1; i++) {
      if (begin != null) begin = begin.next;
    }
    next = begin.next;
    begin.next = null;
    return next;
  }

  public ListNode middleNode(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode fast = head, slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    MiddleOfLinkedList moll = new MiddleOfLinkedList();
    int[] d1 = {1, 2, 3, 4, 5};
    int[] d2 = {1, 2, 3, 4, 5, 6};
    ListNode h1 = ListNode.buildListNode(d1);
    ListNode n1 = moll.middleNode(h1);
    ListNode.print(n1);
    ListNode h2 = ListNode.buildListNode(d2);
    ListNode n2 = moll.middleNode(h2);
    ListNode.print(n2);
  }
}
