package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 *
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes
 * that sum to 0 until there are no such sequences.
 *
 * After doing so, return the head of the final linked list.  You may return any such answer.
 *
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 *
 * Example 1:
 *
 * Input: head = [1,2,-3,3,1]
 * Output: [3,1]
 * Note: The answer [1,2,1] would also be accepted.
 * Example 2:
 *
 * Input: head = [1,2,3,-3,4]
 * Output: [1,2,4]
 * Example 3:
 *
 * Input: head = [1,2,3,-3,-2]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The given linked list will contain between 1 and 1000 nodes.
 * Each node in the linked list has -1000 <= node.val <= 1000.
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
//        if (head == null || head.next == null) return head;
        ListNode node = new ListNode(0);
        node.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefixSum = 0;
        ListNode cur = node;
        while (cur != null) {
            prefixSum += cur.val;
            if (map.containsKey(prefixSum)) {
                map.get(prefixSum).next = cur.next;
                map.clear();
                prefixSum = 0;
                cur = node;
            } else {
                map.put(prefixSum, cur);
                cur = cur.next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        RemoveZeroSumConsecutiveNodesFromLinkedList rzs = new RemoveZeroSumConsecutiveNodesFromLinkedList();
//        int[] data1 = new int[]{ 1,2,3,-3,4 };
        int[] data1 = new int[]{ 0 };
//        int[] data1 = new int[]{ 1,2,-3,3,1 };
        ListNode n1 = ListNode.buildListNode(data1);
        ListNode r1 = rzs.removeZeroSumSublists(n1);
        ListNode.print(r1);
    }
}
