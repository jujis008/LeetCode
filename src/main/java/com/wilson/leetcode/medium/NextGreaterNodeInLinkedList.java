package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 * We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 *
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i,
 * node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
 *
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 *
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a
 * inked list with a head node value of 2, second node value of 1, and third node value of 5.
 *
 *
 *
 * Example 1:
 *
 * Input: [2,1,5]
 * Output: [5,5,0]
 * Example 2:
 *
 * Input: [2,7,4,3,5]
 * Output: [7,0,5,5,0]
 *
 * Example 3:
 *
 * Input: [1,7,5,1,9,2,5,1]
 * Output: [7,9,9,9,0,5,0,0]
 *
 *
 * Note:
 *
 * 1 <= node.val <= 10^9 for each node in the linked list.
 * The given list has length in the range [0, 10000].
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        int len = 0, maxSize = 10000;
        int[] list = new int[maxSize];
        while (node != null) {
            list[len++] = node.val;
            node = node.next;
        }
        int[] result = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int val = stack.peek();
                if (list[val] > list[i]) {
                    result[i] = list[val];
                    stack.push(i);
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = 0;
                stack.push(i);
            }
        }
        return result;
    }

    public int[] nextLargerNodes2(ListNode head) {
        if (head == null || head.next == null) return new int[] {0};
        ListNode node = head, node2 = head;
        int idx = 0, max = head.val;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        while (node.next != null) {
            int val = node.next.val;
            if (node.val <= val) { // 1, 7, 5, 1, 9, 2, 5, 1
                map.put(idx, val); // 0, 7 // 4, 9 // 6, 5
                // 7, 0, 9, 9, 9, 0, 5, 0, 0
            } else {
                map.put(idx, 0);
            }
            max = Math.max(val, max);
            idx++;
            node = node.next;
        }
        int[] result = new int[idx + 1];
        int cursor = 0;
        System.out.println(idx);
        System.out.println("max: " + max);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
            int val = entry.getValue();
            if (val == max) {
                result[cursor++] = 0;
            } else {
                result[cursor++] = val;
            }
//            if (cursor++ == index) {
//                result[index] = 0;
//            } else {
//                for (int i = cursor; i <= index; i++) {
//                    result[i] = val;
//                }
//            }
//            if (key == cursor) {
//                result[cursor++] = val;
//            } else {
//                for (int i = cursor; i < key + 1; i++) {
//                    result[i] = val;
//                }
//                cursor = key + 1;
//            }
        }
//        int count = 0;
//        if (head.val == max) {
//            while (node2.next != null) {
//                if (node2.val != max) {
//                    break;
//                }
//                result[count++] = 0;
//                node2 = node2.next;
//            }
//        }
        result[idx] = 0;
        return result;
    }

    public static void main(String[] args) {
//        int[] data = new int[]{1,7,5,1,9,2,5,1};
//        int[] data = new int[]{2,7,4,3,5};
        int[] data = new int[]{2,1,5};
//        int[] data = new int[]{10,10,7,2,6,2};
//        int[] data = new int[]{10,4,6,4,10};
        System.out.println(data.length);
        ListNode head = ListNode.buildListNode(data);
        NextGreaterNodeInLinkedList ngnill = new NextGreaterNodeInLinkedList();
        int[] arr2 = ngnill.nextLargerNodes2(head);
//        System.out.println(arr);
        for (int i : arr2) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("-----------");

        int[] arr = ngnill.nextLargerNodes(head);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
