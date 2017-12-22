/*
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

 Notice
LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with maximum average.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
return the node 11.

Tags 
Amazon Binary Tree Depth First Search
Related Problems 
Naive Binary Tree Maximum Node 22 %
Easy Minimum Subtree 34 %
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
     * @return the root of the maximum average of subtree
     */
    MyType ans = new MyType(null, 0, 0);
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        return helper(root).maxNode;
    }
    private MyType helper(TreeNode root) {
        if (root == null) {
            return new MyType(null, 0, 0);
        }
        MyType left = helper(root.left);
        MyType right = helper(root.right);
        int sum = left.sum + right.sum + root.val;
        int numNodes = left.numNodes + right.numNodes + 1;
        if (ans.maxNode == null || sum * ans.numNodes > numNodes * ans.sum) {
            ans.sum = sum;
            ans.numNodes = numNodes;
            ans.maxNode = root;
        }
        return new MyType(ans.maxNode, sum, numNodes);
    }
   private class MyType {
        TreeNode maxNode;
        int sum, numNodes;
        private MyType(TreeNode maxNode, int sum, int numNodes) {
            this.maxNode = maxNode;
            this.sum = sum;
            this.numNodes = numNodes;
        }
    }
}