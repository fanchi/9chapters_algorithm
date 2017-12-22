// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

// Have you met this question in a real interview? Yes
// Example
// Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

// A)  3            B)    3 
//    / \                  \
//   9  20                 20
//     /  \                / \
//    15   7              15  7
// The binary tree A is a height-balanced binary tree, but B is not.

// Tags 
// Divide and Conquer Recursion
// Related Problems 
// Medium Validate Binary Search Tree 22 %
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
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return helper(root).isBalanced;
    }
    private class MyType {
        boolean isBalanced;
        int depth;
        private MyType(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }
    private MyType helper(TreeNode root) {
        if (root == null) {
            return new MyType(true, 0);
        }
        MyType left = helper(root.left);
        MyType right = helper(root.right);
        int depth = Math.max(left.depth, right.depth) + 1;
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.depth - right.depth) <= 1;
        return new MyType(isBalanced, depth);
    }
}