package com.wilson.leetcode.medium;

import com.wilson.leetcode.easy.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
 * is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class ConstructBinaryTreeFromPreorderInorderTraversal {
//    root -> left -> right
//    left -> root -> right
    int preorderIdx;
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        preorderIdx = 0;
        final int len = preorder.length;
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, len - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preorderIdx++];
        TreeNode root = new TreeNode(rootVal);
        root.left = arrayToTree(preorder, left, inorderMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inorderMap.get(rootVal) + 1, right);
        return root;
    }

    int preStart;
    int inStart;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int rightBorder) {
        if (inStart >= preorder.length || inorder[inStart] == rightBorder) return null;
        TreeNode root = new TreeNode(preorder[preStart++]);
        root.left = helper(preorder, inorder, root.val);
        inStart++;
        root.right = helper(preorder, inorder, rightBorder);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderInorderTraversal cbt = new ConstructBinaryTreeFromPreorderInorderTraversal();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {3,9,20,15,7};
        TreeNode root = cbt.buildTree1(preorder, inorder);
        TreeNode.printMidOrder(root);
    }
}
