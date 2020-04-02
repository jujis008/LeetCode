package com.wilson.leetcode.medium;

/**
 * Sort a linked list using insertion sort.

 A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
 With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list

 Algorithm of Insertion Sort:

 Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 It repeats until no input elements remain.

 Example 1:

 Input: 4->2->1->3
 Output: 1->2->3->4
 Example 2:

 Input: -1->5->3->4->0
 Output: -1->0->3->4->5
 * Created by i324291 on 2019/4/5.
 */
public class InsertionSortList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        while (head.next != null) {
            if (head.val > head.next.val) {
                ListNode cur = head.next;
                ListNode prev = newHead;
                while (prev.next.val < cur.val) {
                    prev = prev.next;
                }
                head.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            } else {
                head = head.next;
            }
        }
        return newHead.next;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        InsertionSortList isl = new InsertionSortList();
        ListNode head, cur = new ListNode(4);
        head = cur;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(1);
        cur = cur.next;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(-1);
        isl.printList(isl.insertionSortList(head));
    }
}
