package com.wilson.leetcode.hard;

import com.wilson.leetcode.easy.ListNode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    if (lists.length < 2) return lists[0];
    if (lists.length == 2) return mergeTwoList(lists[0], lists[1]);
    Map<Integer, Integer> map = new TreeMap<>();
    for (ListNode node : lists) {
      while (node != null) {
        Integer val = map.get(node.val);
        if (val != null) {
          val++;
          map.put(node.val, val);
        } else {
          map.put(node.val, 1);
        }
        node = node.next;
      }
    }
    ListNode head = new ListNode(-1);
    ListNode cur = head, temp;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      Integer val = entry.getValue();
      for (int i = 0; i < val; i++) {
        temp = new ListNode(entry.getKey());
        temp.next = null;
        cur.next = temp;
        cur = temp;
      }
    }
    return head.next;
  }

  public ListNode mergeKLists1(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    int front = 0, rear = front + 1;
    int count = 0;
    if (lists.length < 2) return lists[0];
    if (lists.length == 2) return mergeTwoList(lists[0], lists[1]);
    while (rear < lists.length) {
      lists[front] = mergeTwoList(lists[front], lists[rear]);
      front++;
      rear++;
      System.arraycopy(lists, rear - 1, lists, 0, lists.length - front);
    }
    return lists[0];
  }

  private ListNode mergeTwoList(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    ListNode head, cur;
    if (l1.val >= l2.val) {
      cur = l2;
      l2 = l2.next;
    } else {
      cur = l1;
      l1 = l1.next;
    }
    head = cur;
    while (l1 != null && l2 != null) {
      if (l1.val >= l2.val) {
        cur.next = l2;
        l2 = l2.next;
      } else {
        cur.next = l1;
        l1 = l1.next;
      }
      cur = cur.next;
    }
    if (l1 != null) cur.next = l1;
    if (l2 != null) cur.next = l2;
    return head;
  }

  public ListNode merge(ListNode[] lists, int start, int end) {
    if (start > end) return null;
    if (start == end) return lists[start];
    int mid = (start + end) >> 1;
    return mergeTwoList(merge(lists, start, mid), merge(lists, mid + 1, end));
  }

  public ListNode merge(ListNode[] lists) {
    return merge(lists, 0, lists.length - 1);
  }

  public static void main(String[] args) {
    int[] d1 = {1, 4, 5};
    int[] d2 = {1, 3, 4};
    int[] d3 = {2, 6};
    ListNode n1 = ListNode.buildListNode(d1);
    ListNode n2 = ListNode.buildListNode(d2);
    ListNode n3 = ListNode.buildListNode(d3);
    ListNode[] lists = {n1, n2, n3};
    MergeKSortedLists mksl = new MergeKSortedLists();
    long start = System.currentTimeMillis();
    ListNode result = mksl.mergeKLists(lists);
    ListNode.print(result);
    System.out.println("result: " + (System.currentTimeMillis() - start));
    start = System.currentTimeMillis();
    ListNode result2 = mksl.merge(lists);
    ListNode.print(result2);
    System.out.println("result: " + (System.currentTimeMillis() - start));
  }
}

