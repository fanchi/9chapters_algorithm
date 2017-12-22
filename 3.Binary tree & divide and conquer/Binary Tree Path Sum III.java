/*
Give a binary tree, and a target number, find all path that the sum of nodes equal to target, the path could be start and end at any node in the tree.

Have you met this question in a real interview? Yes
Example
Given binary tree:

    1
   / \
  2   3
 /
4
and target = 6. Return :

[
  [2, 4],
  [2, 1, 3],
  [3, 1, 2],
  [4, 2]
]
Tags 
Binary Tree
Related Problems 
Medium Binary Tree Longest Consecutive Sequence II 32 %
Easy Binary Tree Path Sum 21 %
Easy Binary Tree Path Sum II 27 %
*/
/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<ParentTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            ParentTreeNode node = stack.pop();
            List<Integer> path = new ArrayList<>();
            dfs(ans, path, node, target, null);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> path, ParentTreeNode node, int target, ParentTreeNode prev) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(path);
            ans.add(temp);
        }
        
        if (node.left != null && node.left != prev) {
            dfs(ans, path, node.left, target, node);
        }
        if (node.parent != null && node.parent != prev) {
            dfs(ans, path, node.parent, target, node);
        }
        if (node.right != null && node.right != prev) {
            dfs(ans, path, node.right, target, node);
        }
        path.remove(path.size() - 1);
    }
}