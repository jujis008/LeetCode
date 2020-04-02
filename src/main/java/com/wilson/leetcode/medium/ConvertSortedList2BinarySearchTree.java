package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.ListNode;
import com.wilson.leetcode.easy.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * @author i324291
 */
public class ConvertSortedList2BinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    ListNode dummy = new ListNode(~(head.val));
    dummy.next = head;
    ListNode fast = dummy, slow = dummy;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (slow.next != null) {
      ListNode temp = slow.next;
      slow.next = null;
      TreeNode root = new TreeNode(temp.val);
      if (temp != head) root.left = sortedListToBST(head);
      if (temp.next != null) root.right = sortedListToBST(temp.next);
      return root;
    }
    return null;
  }

  public static void main(String[] args) {
    ConvertSortedList2BinarySearchTree csl2bt = new ConvertSortedList2BinarySearchTree();
    int[] d = {-10,-3,0,5,9};
    ListNode head = ListNode.buildListNode(d);
//    ListNode.print(head);
    TreeNode treeNode = csl2bt.sortedListToBST(head);
    TreeNode.printMidOrder(treeNode);
  }
}
