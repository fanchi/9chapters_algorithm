/*
Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

Have you met this question in a real interview? Yes
Example
Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.

Tags 
LinkedIn Linked List
Related Problems 
Easy Merge Two Sorted Arrays 35 %
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
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode curt1 = l1, curt2 = l2, curt = dummy;
        while (curt1 != null && curt2 != null) {
            if (curt1.val < curt2.val) {
                curt.next = curt1;
                curt1 = curt1.next;
            }
            else {
                curt.next = curt2;
                curt2 = curt2.next;
            }
            curt = curt.next;
        }
        if (curt1 != null) {
            curt.next = curt1;
        }
        if (curt2 != null) {
            curt.next = curt2;
        }
        return dummy.next;
    }
}