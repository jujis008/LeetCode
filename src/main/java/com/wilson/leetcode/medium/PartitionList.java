package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 * @author i324291
 */
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) return head;
    ListNode p = new ListNode(0), pn = p, q = new ListNode(0), qn = q;
    for (; head != null; head = head.next) {
      if (head.val < x) {
        pn.next = head;
        pn = pn.next;
      } else {
        qn.next = head;
        qn = qn.next;
      }
    }
    qn.next = null;
    pn.next = q.next;
    return p.next;
  }

  public static void main(String[] args) {
    PartitionList pl = new PartitionList();
    int[] d = {1, 4, 3, 2, 5, 2};
    ListNode n = ListNode.buildListNode(d);
    ListNode r = pl.partition(n, 3);
    ListNode.print(r);
  }
}
