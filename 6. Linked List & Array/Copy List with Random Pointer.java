/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Have you met this question in a real interview? Yes
Example
Challenge 
Could you solve it with O(1) space?

Tags 
Hash Table Linked List Uber
Related Problems 
Easy Clone Binary Tree 46 %
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curt = head;
        while (curt != null) {
            RandomListNode newNode = new RandomListNode(curt.label);
            map.put(curt, newNode);
            curt = curt.next;
        }
        curt = head;
        while (curt != null) {
            RandomListNode oldNext = curt.next;
            RandomListNode oldRandom = curt.random;
            map.get(curt).next = map.get(oldNext);
            if (oldRandom != null) {
                map.get(curt).random = map.get(oldRandom);
            }
            curt = curt.next;
        }
        return map.get(head);
    }
}