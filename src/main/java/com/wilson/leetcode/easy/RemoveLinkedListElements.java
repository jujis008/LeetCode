package com.wilson.leetcode.easy;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 * @author i324291
 */
public class RemoveLinkedListElements {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    ListNode node = new ListNode(-1);
    node.next = head;
    head = node;
    while (node.next != null) {
      if (node.next.val == val) {
        node.next = node.next.next;
      } else {
        node = node.next;
      }
    }
    return head.next;
  }

  public void printList(ListNode head) {
    if (head == null) return;
    ListNode node = head.next;
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
    System.out.println();
  }

  public ListNode createList(int[] data) {
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
    return head;
  }

  public static void main(String[] args) {
    RemoveLinkedListElements rlle = new RemoveLinkedListElements();
//    int[] data = {1, 2, 6, 3, 4, 5, 6};
    int[] data = {1};
    ListNode list = rlle.createList(data);
    rlle.printList(list);
    ListNode node = rlle.removeElements(list, 2);
    rlle.printList(node);
  }
}
