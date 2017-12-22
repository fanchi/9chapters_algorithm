/*
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

 Notice
LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 
return the node 1.

Tags 
Binary Tree Microsoft Depth First Search Yelp
Related Problems 
Naive Binary Tree Maximum Node 22 %
Easy Subtree with Maximum Average 26 %
Easy Binary Tree Longest Consecutive Sequence 31 %
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
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    TreeNode ans = null;
    int min = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        helper(root);
        return ans;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right + root.val;
        if (sum < min) {
            min = sum;
            ans = root;
        }
        return sum;
    }
}