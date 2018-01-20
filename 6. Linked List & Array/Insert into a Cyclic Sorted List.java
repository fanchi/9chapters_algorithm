/*
Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.

 Notice
3->5->1 is a cyclic list, so 3 is next node of 1.
3->5->1 is same with 5->1->3

Have you met this question in a real interview? Yes
Example
Given a list, and insert a value 4:
3->5->1
Return 5->1->3->4

Tags 
Amazon Linked List
Related Problems 
Naive Insert Node in Sorted Linked List 21 %
Easy Insertion Sort List 31 %
*/
/*
two cases to consider:

2->3->5->(2)

not smaller than 2 and not bigger than 5
smaller than 2, or bigger than 5
*/
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param node: a list node in the list
     * @param x: An integer
     * @return: the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // write your code here
        if (node == null) {
            ListNode newNode = new ListNode(x);
            newNode.next = newNode; // don't forget this step
            return newNode;
        }
        ListNode minNode = node, maxNode = node;
        ListNode curt = node.next;
        while (curt != node) {
            // System.out.println(curt.val);
            if (curt.val < minNode.val) {
                minNode = curt;
            }
            if (curt.val > maxNode.val) {
                maxNode = curt;
            }
            curt = curt.next;
        }
        //System.out.println(minNode.val + "," + maxNode.val);
        ListNode newNode = new ListNode(x);
        if (x > maxNode.val || x < minNode.val) {
            ListNode temp = maxNode.next;
            maxNode.next = newNode;
            newNode.next = temp;
            return newNode;
        }
        else {
            curt = minNode;
            while (curt.val < x) {
                curt = curt.next;
            }
            if (curt.val > x) {
                ListNode temp = curt.next;
                newNode.val = curt.val;
                curt.val = x;
                curt.next = newNode;
                newNode.next = temp;
                return curt;
            }
            else {
                ListNode temp = curt.next;
                curt.next = newNode;
                newNode.next = temp;
                return newNode;
            }
        }
    }
}