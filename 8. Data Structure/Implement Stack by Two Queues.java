/*
Implement a stack by two queues. The queue is first in first out (FIFO). That means you can not directly pop the last element in a queue.

Have you met this question in a real interview? Yes
Example
push(1)
pop()
push(2)
isEmpty() // return false
top() // return 2
pop()
isEmpty() // return true
Tags 
Queue Stack
Related Problems 
Easy Implement Stack 43 %
*/
class Stack {
    // Push a new item into the stack
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public void push(int x) {
        // Write your code here
        q1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if (q1.isEmpty()) {
            return;
        }
        int size = q1.size();
        for (int i = 0; i < size - 1; i ++) {
            q2.offer(q1.poll());
        }
        q1.poll();
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        if (q1.isEmpty()) {
            return 0;
        }
        int size = q1.size();
        for (int i = 0; i < size - 1; i ++) {
            q2.offer(q1.poll());
        }
        int val = q1.poll();
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        q1.offer(val);
        return val;
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty();
    }    
}