/*
Merge k sorted linked lists and return it as one sorted list.

Analyze and describe its complexity.

Have you met this question in a real interview? Yes
Example
Given lists:

[
  2->4->null,
  null,
  -1->null
],
return -1->2->4->null.

Tags 
Twitter LinkedIn Linked List Airbnb Facebook Priority Queue Divide and Conquer Heap Uber Google
Related Problems 
Medium Merge k Sorted Arrays 27 %
Easy Merge Two Sorted Arrays 35 %
Medium Ugly Number II 24 %
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        PriorityQueue<MyType> pq = new PriorityQueue<>(lists.size(), comp);
        ListNode[] heads = new ListNode[lists.size()];
        for (int i = 0; i < lists.size(); i ++) {
            ListNode head = lists.get(i);
            if (head == null) {
                continue;
            }
            MyType myType = new MyType(head, i);
            pq.offer(myType);
            heads[i] = head.next;
        }
        while (!pq.isEmpty()) {
            MyType myType = pq.poll();
            ListNode node = myType.node;
            int ind = myType.ind;
            curt.next = node;
            curt = curt.next;
            if (heads[ind] != null) {
                MyType newType = new MyType(heads[ind], ind);
                pq.offer(newType);
                heads[ind] = heads[ind].next;
            }
        }
        return dummy.next;
    }
    class MyType {
        ListNode node;
        int ind;
        public MyType(ListNode node, int ind) {
            this.node = node;
            this.ind = ind;
        }
    }
    static Comparator<MyType> comp = new Comparator<MyType>(){
        public int compare(MyType m1, MyType m2) {
            return m1.node.val - m2.node.val;
        }
    };
}
