/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

 Notice
You don't need to implement the remove method.

Have you met this question in a real interview? Yes
Example
Given the list [[1,1],2,[1,1]], By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Given the list [1,[4,[6]]], By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

Tags 
Stack Recursion Google Data Structure Design Snapchat
Related Problems 
Medium Flatten 2D Vector 45 %
Easy Nested List Weight Sum 45 %
Medium Zigzag Iterator II 33 %
Medium Zigzag Iterator 44 %
Easy Flatten Binary Tree to Linked List 33 %
*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        this.stack = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i --) {
            stack.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        if (stack.isEmpty()) {
            return false;
        }
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger nested = stack.pop();
            for (int i = nested.getList().size() - 1; i >= 0; i --) {
                stack.push(nested.getList().get(i));
            }
        }
        if (!stack.isEmpty() && stack.peek().isInteger()) {
            return true;
        }
        return false;
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */