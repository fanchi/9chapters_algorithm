/*
Given an array of integers, find a contiguous subarray which has the largest sum.

 Notice
The subarray should contain at least one number.

Have you met this question in a real interview? Yes
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.

Challenge 
Can you do it in time complexity O(n)?

Tags 
Greedy LinkedIn Array LintCode Copyright Subarray Enumeration
Related Problems 
Hard Maximum Subarray V 29 %
Medium Maximum Subarray IV 35 %
Medium Maximum Average Subarray 18 %
Medium Continuous Subarray Sum 25 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 25 %
*/
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int global = nums[0], local = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            local = Math.max(local + nums[i], nums[i]);
            global = Math.max(global, local);
        }
        return global;
    }
}