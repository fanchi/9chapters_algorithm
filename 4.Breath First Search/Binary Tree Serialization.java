/*
Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

 Notice
There is no limit of how you deserialize or serialize a binary tree, LintCode will take your output of serialize as the input of deserialize, it won't check the result of serialize.

Have you met this question in a real interview? Yes
Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.

Tags 
Binary Tree Microsoft Uber Yahoo
Related Problems 
Medium Search Range in Binary Search Tree 37 %
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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#,");
            }
            else {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        while (sb.charAt(sb.length() - 1) == ',' || sb.charAt(sb.length() - 1) == '#') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] splited = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(splited[0]));
        queue.offer(root);
        boolean isLeft = true;
        TreeNode parent = null;
        for (int i = 1; i < splited.length; i ++) {
            if (isLeft) {
                parent = queue.poll();
            }
            TreeNode node = null;
            if (!splited[i].equals("#")) {
                node = new TreeNode(Integer.valueOf(splited[i]));
                queue.offer(node);
            }
            if (isLeft) {
                parent.left = node;
            }
            else {
                parent.right = node;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}
