/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

Have you met this question in a real interview? Yes
Example
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Tags 
Linked List Facebook
Related Problems 
Easy Swap Nodes in Pairs 35 %
Medium Rotate List 25 %
Medium Reverse Linked List II 30 %
Easy Reverse Linked List 40 %
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null) {
            head = helper(head, k);
        }
        return dummy.next;
    }
    
    // head->n1->n2->...->nk->nk+1
    // head->nk->nk-1->...->n2->n1->nk+1
    // return n1
    private ListNode helper(ListNode head, int k) {
        ListNode curt = head;
        int pos = 0;
        while (curt != null) {
            curt = curt.next;
            pos ++;
            if (pos == k) {
                break;
            }
        }
        if (curt == null) {
            return null;
        }
        ListNode n1 = head.next, nk = curt;
        ListNode nkplus = nk.next;
        ListNode prev = null;
        curt = n1;
        while (curt != nkplus) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        head.next = prev;
        n1.next = nkplus;
        return n1;
    }
}