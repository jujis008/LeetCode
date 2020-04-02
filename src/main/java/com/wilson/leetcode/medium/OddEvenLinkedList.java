package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 *
 * @author i324291
 */
public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode oddHead = head, evenHead = head.next, even = evenHead;
    while (even != null && even.next != null) {
      oddHead.next = oddHead.next.next;
      even.next = even.next.next;
      oddHead = oddHead.next;
      even = even.next;
    }
    oddHead.next = evenHead;
    return head;
  }

  public static void main(String[] args) {
    OddEvenLinkedList oell = new OddEvenLinkedList();
    int[] d = {1, 2, 3, 4, 5};
    ListNode head = ListNode.buildListNode(d);
    ListNode node = oell.oddEvenList(head);
    ListNode.print(node);
  }
}
