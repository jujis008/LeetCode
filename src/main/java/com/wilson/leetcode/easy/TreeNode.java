package com.wilson.leetcode.easy;

/**
 * a tree node
 * @author i324291
 */
public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;
  TreeNode() {}
  public TreeNode(int x) { val = x; }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

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
