/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Have you met this question in a real interview? Yes
Example
Given 1->4->3->2->5->2->null and x = 3,
return 1->2->2->4->3->5->null.

Tags 
Two Pointers Linked List
Related Problems 
Medium Partition Array 30 %
*/
/*
rightCur.next = null; // this is important, or else Memory Limite exceed
*/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode leftDummy = new ListNode(0), rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            }
            else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        left.next = null;
        right.next =null;
        if (left != null) {
            left.next = rightDummy.next;
            return leftDummy.next;
        }
        else {
            return rightDummy.next;
        }
    }
}