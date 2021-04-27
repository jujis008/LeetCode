package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
 * postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class ConstructBinaryTreeFromInorderPostorderTraversal {
    int postorderIdx;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        final int len = inorder.length;
        postorderIdx = len - 1;
        inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        return arrayToTree(postorder, 0, len - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right || postorderIdx < 0) return null;
        int rootVal = postorder[postorderIdx--];
        System.out.println("rootVal: " + rootVal);
        System.out.println("left: " + left);
        System.out.println("right: " + right);
        TreeNode root = new TreeNode(rootVal);
        root.right = arrayToTree(postorder, inorderMap.get(rootVal) + 1, right);
        root.left = arrayToTree(postorder, left, inorderMap.get(rootVal) - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderPostorderTraversal cbt = new ConstructBinaryTreeFromInorderPostorderTraversal();
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {3,9,20,15,7};
        TreeNode root = cbt.buildTree(inorder, postorder);
        TreeNode.printMidOrder(root);
    }
}
