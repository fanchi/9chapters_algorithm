/*
Sort a linked list in O(n log n) time using constant space complexity.

Have you met this question in a real interview? Yes
Example
Given 1->3->2->null, sort it to 1->2->3->null.

Challenge 
Solve it by merge sort & quick sort separately.

Tags 
Linked List
Related Problems 
Easy Insertion Sort List 31 %
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head = sortList(head);
        head2 = sortList(head2);
        return merge(head, head2);
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        else if (head1 == null) {
            return head2;
        }
        else if (head2 == null) {
            return head1;
        }
        else {
            ListNode head = head1.val < head2.val ? head1 : head2;
            ListNode curt1, curt2;
            if (head == head1) {
                curt1 = head1.next;
                curt2 = head2;
            }
            else {
                curt1 = head1;
                curt2 = head2.next;
            }
            ListNode curt = head;
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
            return head;
        }
    }
    private ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}