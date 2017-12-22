/*
Your are given a binary tree in which each node contains a value. Design an algorithm to get all paths which sum to a given value. The path does not need to start or end at the root or a leaf, but it must go in a straight line down.

Have you met this question in a real interview? Yes
Example
Given a binary tree:

    1
   / \
  2   3
 /   /
4   2
for target = 6, return

[
  [2, 4],
  [1, 3, 2]
]
Tags 
Recursion Binary Tree Depth First Search
Related Problems 
Easy Binary Tree Path Sum 21 %
Hard Binary Tree Path Sum III 37 %
Medium Binary Tree Maximum Path Sum 25 %
*/
// 不知道为啥是简单题，反正一下午也没写出来。
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
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, root, target, 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> path, TreeNode root, int target, int level) {
        if (root == null) {
            return;
        }
        int sum = 0;
        path.add(root.val);
        for (int i = level; i >= 0; i --) {
            sum += path.get(i);
            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                for (int j = i; j <= level; j ++) {
                    temp.add(path.get(j));
                }
                ans.add(temp);
            }
        }
        dfs(ans, path, root.left, target, level + 1);
        dfs(ans, path, root.right, target, level + 1);
        path.remove(path.size() - 1);
    }
}