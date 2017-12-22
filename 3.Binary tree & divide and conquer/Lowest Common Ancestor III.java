/*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

 Notice
node A or node B may not exist in tree.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

Tags 
LinkedIn LintCode Copyright Binary Tree Facebook
Related Problems 
Easy Lowest Common Ancestor II 35 %
Medium Lowest Common Ancestor 40 %
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
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        Node node = helper(root, A, B);
        if (node != null && node.hasA && node.hasB) {
            return node.node;
        }
        else {
            return null;
        }
    }
    private class Node {
        TreeNode node;
        boolean hasA, hasB;
        private Node(TreeNode node, boolean hasA, boolean hasB) {
            this.node = node;
            this.hasA = hasA;
            this.hasB = hasB;
        }
    }
    private Node helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        Node left = helper(root.left, A, B);
        Node right = helper(root.right, A, B);
        if (left != null && left.hasA && left.hasB) {
            return left;
        }
        if (right != null && right.hasA && right.hasB) {
            return right;
        }
        boolean hasA = root == A || (left != null && left.hasA) || (right != null && right.hasA);
        boolean hasB = root == B || (left != null && left.hasB) || (right != null && right.hasB);
        if (hasA && hasB) {
            return new Node(root, true, true);
        }
        else if (hasA) {
            return new Node(root, true, false);
        }
        else if (hasB) {
            return new Node(root, false, true);
        }
        else {
            return null;
        }
    }
}