/*
Given a binary tree, return all root-to-leaf paths.

Have you met this question in a real interview? Yes
Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]
Tags 
Binary Tree Binary Tree Traversal Google Facebook
Related Problems 
Medium Tree Longest Path With Same Value 13 %
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans.add(String.valueOf(root.val));
            return ans;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for (String str: left) {
            str = root.val + "->" + str;
            ans.add(str);
        }
        for (String str: right) {
            str = root.val + "->" + str;
            ans.add(str);
        }
        return ans;
    }
}