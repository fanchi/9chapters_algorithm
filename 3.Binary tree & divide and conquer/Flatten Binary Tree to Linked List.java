// Flatten a binary tree to a fake "linked list" in pre-order traversal.

// Here we use the right pointer in TreeNode as the next pointer in ListNode.

//  Notice
// Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

// Have you met this question in a real interview? Yes
// Example
//               1
//                \
//      1          2
//     / \          \
//    2   5    =>    3
//   / \   \          \
//  3   4   6          4
//                      \
//                       5
//                        \
//                         6
// Challenge 
// Do it in-place without any extra memory.

// Tags 
// Binary Tree Depth First Search
// Related Problems 
// Medium Flatten 2D Vector 46 %
// Medium Flatten Nested List Iterator 28 %
// Easy Convert Binary Tree to Linked Lists by Depth 40 %
// Medium Convert Binary Search Tree to Doubly Linked List 30 %
// Medium Convert Sorted List to Balanced BST 30 %
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        else {
            // do nothing
        }
    }
}