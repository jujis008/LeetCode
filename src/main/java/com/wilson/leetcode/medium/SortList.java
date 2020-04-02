package com.wilson.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 *
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 *
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * Created by i324291 on 2019/4/3.
 */
public class SortList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return mergeList(sortList(head), sortList(fast));
    }

    private ListNode mergeList(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        if (node1 == null && node2 == null) return node1;
        ListNode head, cur;
        if (node1.val > node2.val) {
            cur = node2;
            node2 = node2.next;
        } else {
            cur = node1;
            node1 = node1.next;
        }
        head = cur;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                cur.next = node2;
                node2 = node2.next;
            } else {
                cur.next = node1;
                node1 = node1.next;
            }
            cur = cur.next;
        }
        if (node1 != null) cur.next = node1;
        if (node2 != null) cur.next = node2;
        return head;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) return head;
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode cur = new ListNode(list.get(0));
        head = cur;
        for (int i = 1; i < list.size(); i++) {
            cur.next = new ListNode(list.get(i));
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        SortList sl = new SortList();
        ListNode head, cur = new ListNode(4);
        head = cur;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(-1);
        sl.printList(sl.sortList1(head));
    }
}
