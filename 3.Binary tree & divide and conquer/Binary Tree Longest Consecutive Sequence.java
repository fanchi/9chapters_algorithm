/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Have you met this question in a real interview? Yes
Example
For example,

   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.

   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

Tags 
Binary Tree Google
Related Problems 
Medium Tree Longest Path With Same Value 13 %
Medium Binary Tree Longest Consecutive Sequence III 38 %
Medium Binary Tree Longest Consecutive Sequence II 32 %
Easy Minimum Subtree 34 %
Medium Longest Consecutive Sequence 34 %
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    int longest = 0;
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        helper(root);
        return longest;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 1, tempLeft = 0, tempRight = 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if (root.left != null && root.left.val == root.val + 1) {
            tempLeft = left + 1;
        }
        if (root.right != null && root.right.val == root.val + 1) {
            tempRight = right + 1;
        }
        ans = Math.max(ans, Math.max(tempLeft, tempRight));
        longest = Math.max(longest, ans);
        return ans;
    }
}