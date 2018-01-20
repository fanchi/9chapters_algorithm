/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth. Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Have you met this question in a real interview? Yes
Example
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1, 4 * 1 * 2 + 1 * 2 * 1 = 10)
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 42 + 63 = 27)

Tags 
LinkedIn Recursion Depth First Search
Related Problems 
Medium Flatten Nested List Iterator 28 %
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

//__________iteratively_________
public class Solution{
    public int depthSum(List<NestedInteger> nestedList){
        if(nestedList == null){
            return 0;
        }
        Queue<NestedInteger> queue = new LinkedList<>();
        int depth = 0;
        int sum = 0;
        for(NestedInteger list: nestedList){
           queue.offer(list);
        }
        while(!queue.isEmpty()){
             depth ++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
            NestedInteger curList = queue.poll();
            if(curList.isInteger()){
                sum += curList.getInteger() * depth;
            }
            else{
                for(NestedInteger list: curList.getList()){
                    queue.offer(list);
                }
            }
            }//for i
        }//while
        return sum;
    }
}
--------recusively---------
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        return helper(nestedList, 1);
    }
    private int helper(List<NestedInteger> nestedList, int level) {
       int ans = 0;
       for (NestedInteger nested: nestedList) {
           if (nested.isInteger()) {
               ans += level * nested.getInteger();
           }
           else {
               ans += helper(nested.getList(), level + 1);
           }
       }
       return ans;
    }
}