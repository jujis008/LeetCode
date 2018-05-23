package com.wilson.leetcode.easy;

/**
 * Created by i324291 on 2017/8/29.
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 * A:          a1 → a2
 *                     ↘
 *                      c1 → c2 → c3
 *                     ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            p = (p != null ? p.next : headB);
            q = (q != null ? q.next : headA);
        }
        return p;
    }

    public ListNode getIntersectionNodeWithLength(ListNode headA, ListNode headB) {
        int len1 = checkLength(headA);
        int len2 = checkLength(headB);
        ListNode p = headA;
        ListNode q = headB;
        while (len1 > len2) {
            p = p.next;
            len1 --;
        }

        while (len1 < len2) {
            q = q.next;
            len2 --;
        }

        while (p != q) {
            p = p.next;
            q = q.next;
        }

        return p;
    }

    private int checkLength(ListNode listNode) {
        int len = 0;
        while (listNode != null) {
            len++;
            listNode = listNode.next;
        }
        return len;
    }

    private void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
