/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Have you met this question in a real interview? Yes
Example
Tags 
Linked List Google Uber Zenefits
Related Problems 
Hard LFU Cache 19 %
*/
public class LRUCache {
    /*
    * @param capacity: An integer
    */
    int k;
    Node head, tail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        // do intialization if necessary
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        k = capacity;
        map = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        Node prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
        moveToTail(node);
        return node.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            Node prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
            node.val = value;
            moveToTail(node);
        }
        else {
            Node newNode = new Node(key, value);
            if (map.keySet().size() == k) {
                Node first = head.next;
                Node next = first.next;
                head.next = next;
                next.prev = head;
                first.prev = null;
                first.next = null;
                map.remove(first.key);
            }
            moveToTail(newNode);
            map.put(key, newNode);
        }
    }
    private void moveToTail(Node node) {
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }
    private class Node {
        int key, val;
        Node prev, next;
        private Node (int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}