package com.wilson.leetcode.medium;

import java.util.Stack;

/**
 * Created by i324291 on 2017/8/27.
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 *
 */

public class AddTwoNumbersII {
    private int carry = 0;
    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) return listNode2;
        if (listNode2 == null) return listNode1;
        ListNode returnNode;
        int len1 = checkLength(listNode1);
        int len2 = checkLength(listNode2);
        if (len1 > len2) {
            returnNode = add(listNode2, listNode1, len1 - len2);
        } else {
            returnNode = add(listNode1, listNode2, len2 - len1);
        }
        if (carry > 0) {
            ListNode carryNode = returnNode;
            returnNode = new ListNode(carry);
            returnNode.next = carryNode;

        }
        return returnNode;
    }

    private ListNode add(ListNode l1, ListNode l2, int diff) {
        if (l1.next == null && l2.next == null) {
            int sum = l1.data + l2.data;
            carry = sum / 10;
            return new ListNode(sum % 10);
        }
        ListNode result, next;
        int sum;
        if (diff == 0) {
            next = add(l1.next, l2.next, 0);
            sum = l1.data + l2.data + carry;
        } else {
            next = add(l1, l2.next, diff - 1);//why?
            sum = l2.data + carry;
        }
        carry = sum / 10;
        result = new ListNode(sum % 10);
        result.next = next;
        return result;
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
            System.out.print(" -> " + listNode.data);
            listNode = listNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        ListNode returnNode1 = new ListNode(0);
        ListNode returnNode2 = new ListNode(0);

        ListNode l1 = returnNode1;
        ListNode l2 = returnNode2;
        for (int i = 0; i < 4; i++) {
            l1.next = new ListNode(i+5);
            l1 = l1.next;
            l2.next = new ListNode(i+5);
            l2 = l2.next;
        }
        addTwoNumbersII.printList(returnNode1.next);
        addTwoNumbersII.printList(returnNode2.next);
        addTwoNumbersII.printList(addTwoNumbersII.addTwoNumbers(returnNode1.next, returnNode2.next));
        addTwoNumbersII.printList(addTwoNumbersII.addTwoNumbersStack(returnNode1.next, returnNode2.next));
    }

    public ListNode addTwoNumbersStack(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = pushToStack(l1);
        Stack<Integer> stack2 = pushToStack(l2);

        int sum = 0;
        ListNode result = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
           sum += (!stack1.isEmpty() ? stack1.pop() : 0);
           sum += (!stack2.isEmpty() ? stack2.pop() : 0);
           result.data = sum % 10;
           ListNode carryNode = new ListNode(sum / 10);
           carryNode.next = result;
           result = carryNode;
           sum /= 10;
        }
        return result.data == 0 ? result.next : result;
    }

    private Stack<Integer> pushToStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.data);
            listNode = listNode.next;
        }
        return stack;
    }
}
