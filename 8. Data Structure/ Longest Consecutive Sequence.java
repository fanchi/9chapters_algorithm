/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Have you met this question in a real interview? Yes
Clarification
Your algorithm should run in O(n) complexity.

Example
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Tags 
Array
Related Problems 
Medium Binary Tree Longest Consecutive Sequence III 39 %
Easy Binary Tree Longest Consecutive Sequence 32 %
*/
public class Solution {
    /*
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int val: num) {
            set.add(val);
        }
        int ans = 0;
        for (int val: num) {
            int low = val - 1, high = val + 1;
            while (set.contains(low)) {
                set.remove(low);
                low --;
            }
            while (set.contains(high)) {
                set.remove(high);
                high ++;
            }
            ans = Math.max(ans, high - low - 1);
        }
        return ans;
    }
}