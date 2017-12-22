/*
Convert a binary search tree to doubly linked list with in-order traversal.

Have you met this question in a real interview? Yes
Example
Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
return 1<->2<->3<->4<->5

Tags 
Linked List
Related Problems 
Easy Convert Binary Tree to Linked Lists by Depth 40 %
Easy Flatten Binary Tree to Linked List 33 %
Medium Convert Sorted List to Balanced BST 30 %
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if (root == null) {
            return null;
        }
        DoublyListNode left = bstToDoublyList(root.left);
        DoublyListNode ans = left;
        while (left != null && left.next != null) {
            left = left.next;
        }
        DoublyListNode mid = new DoublyListNode(root.val);
        DoublyListNode right = bstToDoublyList(root.right);
        if (left != null) {
            left.next = mid;
            mid.prev = left;
        }
        mid.next = right;
        if (right != null) {
            right.prev = mid;
        }
        if (ans != null) {
            return ans;
        }
        else {
            return mid;
        }
    }
}
