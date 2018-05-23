package com.wilson.leetcode.medium;


/**
 * Created by i324291 on 2017/8/1.
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int x) {
            this.data = x;
        }
    }
    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode returnNode = new ListNode(0);
        ListNode p = listNode1;
        ListNode q = listNode2;
        ListNode cur = returnNode;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null ? p.data : 0);
            int y = (q != null ? q.data : 0);
            int sum = carry + x + y;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            p = (p != null ? p.next : null);
            q = (q != null ? q.next : null);
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return returnNode.next;
    }

    public void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.data + "->");
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        AddTwoNumbers atn = new AddTwoNumbers();

        ListNode listNode = new ListNode(7);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(3);

        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = atn.addTwoNumbers(listNode, listNode1);
        atn.printList(listNode2);
        atn.printList(listNode);
        atn.printList(listNode1);
    }
}