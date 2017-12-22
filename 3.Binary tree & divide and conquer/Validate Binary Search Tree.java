/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Have you met this question in a real interview? Yes
Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).

Tags 
Divide and Conquer Recursion Binary Tree Binary Search Tree
Related Problems 
Medium BST Swapped Nodes 13 %
Medium Inorder Successor in Binary Search Tree 33 %
Easy Balanced Binary Tree 38 %
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private class Node {
        int min, max;
        boolean isBST;
        private Node(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        return helper(root).isBST;
    }
    private Node helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new Node(root.val, root.val, true);
        }
        else if (root.left != null && root.right != null) {
            Node left = helper(root.left);
            Node right = helper(root.right);
            int max = Math.max(Math.max(left.max, right.max), root.val);
            int min = Math.min(Math.min(left.min, right.min), root.val);
            return new Node(min, max, root.val > left.max && root.val < right.min && left.isBST && right.isBST);
        }
        else if (root.left != null) {
            Node left = helper(root.left);
            int max = Math.max(left.max, root.val);
            int min = Math.min(left.min, root.val);
            return new Node(min, max, root.val > left.max && left.isBST);
        }
        else if (root.right != null) {
            Node right = helper(root.right);
            int max = Math.max(right.max, root.val);
            int min = Math.min(right.min, root.val);
            return new Node(min, max, root.val < right.min && right.isBST);
        }
        else {
            return null;
        }
    }
}