/*
Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.

 Notice
It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)

Have you met this question in a real interview? Yes
Example
Given tree = [2,1] and node = 1:

  2
 /
1
return node 2.

Given tree = [2,1,3] and node = 2:

  2
 / \
1   3
return node 3.

Challenge 
O(h), where h is the height of the BST.

Tags 
Binary Tree Binary Search Tree
Related Problems 
Medium BST Swapped Nodes 13 %
Medium Validate Binary Search Tree 22 %
Hard Binary Search Tree Iterator 36 %
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
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            if (curt != p) {
                curt = curt.right;
                continue;
            }
            if (curt.right == null) {
                if (!stack.isEmpty()) {
                    return stack.pop();
                }
                else {
                    return null;
                }
            }
            else {
                curt = curt.right;
                while (curt.left != null) {
                    curt = curt.left;
                }
                return curt;
            }
        }
        return null;
    }
}