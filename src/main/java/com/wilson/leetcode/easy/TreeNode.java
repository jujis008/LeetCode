package com.wilson.leetcode.easy;

/**
 * a tree node
 * @author i324291
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  public TreeNode(int x) { val = x; }

  public static void printMidOrder(TreeNode root) {
    if (root == null) {
      System.out.print("null. ");
      return;
    }
    if (root.left != null) printMidOrder(root.left);
    System.out.print(root.val + " ");
    if (root.right != null) printMidOrder(root.right);
  }
}
