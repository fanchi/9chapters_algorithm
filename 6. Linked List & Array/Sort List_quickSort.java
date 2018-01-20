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
        if (head == null) {
            return head;
        }
        ListNode right = new ListNode(0), mid = new ListNode(0), left = new ListNode(0);
        ListNode curt = head, curtRight = right, curtMid = mid, curtLeft = left;
        ListNode midNode = findMid(head);
        int pivot = midNode.val;
        while (curt != null) {
            if (curt.val < pivot) {
                curtLeft.next = curt;
                curtLeft = curtLeft.next;
            }
            else if (curt.val == pivot) {
                curtMid.next = curt;
                curtMid = curtMid.next;
            }
            else {
                curtRight.next = curt;
                curtRight = curtRight.next;
            }
            curt = curt.next;
        }
        curtLeft.next = null;
        curtMid.next = null;
        curtRight.next = null;
        left.next = sortList(left.next);
        right.next = sortList(right.next);
        ListNode tail = findTail(left);
        tail.next = mid.next;
        tail = findTail(left);
        tail.next = right.next;
        return left.next;
    }
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode findTail(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curt = head;
        while (curt != null && curt.next != null) {
            curt = curt.next;
        }
        return curt;
    }
}