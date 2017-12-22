/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
Tags 
Queue LinkedIn Binary Tree Binary Tree Traversal Breadth First Search
*/
// Use stack, not queue
// 两层while(!currentLevel.isEmpty())循环
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
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            if (!stack1.isEmpty()) {
                int size = stack1.size();
                for (int i = 0; i < size; i ++) {
                    TreeNode node = stack1.pop();
                    level.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
            }
            else if (!stack2.isEmpty()) {
                int size = stack2.size();
                for (int i = 0; i < size; i ++) {
                    TreeNode node = stack2.pop();
                    level.add(node.val);
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
            }
            else {
                // no likely to happen
            }
            if (level.size() > 0) {
                ans.add(level);
            }
        }
        return ans;
    }
}