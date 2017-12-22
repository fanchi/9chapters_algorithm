/*
Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.

Have you met this question in a real interview? Yes
Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]
Tags 
Binary Tree Binary Tree Traversal
Related Problems 
Hard Binary Tree Path Sum III 37 %
Easy Binary Tree Path Sum II 27 %
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
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null && root.val == target) {
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            ans.add(temp);
            return ans;
        }
        List<List<Integer>> left = binaryTreePathSum(root.left, target - root.val);
        List<List<Integer>> right = binaryTreePathSum(root.right, target - root.val);
        for (List<Integer> list: left) {
            list.add(0, root.val);
            ans.add(list);
        }
        for (List<Integer> list: right) {
            list.add(0, root.val);
            ans.add(list);
        }
        return ans;
    }
}