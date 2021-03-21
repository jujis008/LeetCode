package com.wilson.leetcode.easy;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 *
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.

 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
public class ConvertBinaryNumberLinkedListToInteger {
    public int getDecimalValue1(ListNode head) {
        ListNode node = head;
        StringBuilder sb = new StringBuilder(31);
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public int getDecimalValue(ListNode head) {
        ListNode node = head;
        int result = 0;
        while (node != null) {
            result = result * 2 + node.val;
            node = node.next;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
//        int[] data = new int[]{0,0};
        ListNode head = ListNode.buildListNode(data);
        ConvertBinaryNumberLinkedListToInteger cbn = new ConvertBinaryNumberLinkedListToInteger();
        System.out.println(cbn.getDecimalValue(head));
    }
}
