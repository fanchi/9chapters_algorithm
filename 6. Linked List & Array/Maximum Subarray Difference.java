/*
Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

 Notice
The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
For [1, 2, -3, 1], return 6.

Challenge 
O(n) time and O(n) space.

Tags 
Greedy Enumeration LintCode Copyright Array Subarray Forward-Backward Traversal
Related Problems 
Medium Maximum Product Subarray 30 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 25 %
*/

//left to right record global min and global max
//right to left recrod golbal min and global max

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int len = nums.length;
        int[] minLeft = new int[len], maxLeft = new int[len], minRight = new int[len], maxRight = new int[len];
        minLeft[0] = nums[0];
        maxLeft[0] = nums[0];
        minRight[len - 1] = nums[len - 1];
        maxRight[len - 1] = nums[len - 1];
        int min = nums[0], max = nums[0];
        for (int i = 1; i < len; i ++) {
            min = Math.min(min + nums[i], nums[i]);
            max = Math.max(max + nums[i], nums[i]);
            minLeft[i] = Math.min(minLeft[i - 1], min);
            maxLeft[i] = Math.max(maxLeft[i - 1], max);
        }
        min = nums[len - 1];
        max = nums[len - 1];
        for (int i = len - 2; i >= 0; i --) {
            min = Math.min(min + nums[i], nums[i]);
            max = Math.max(max + nums[i], nums[i]);
            minRight[i] = Math.min(minRight[i + 1], min);
            maxRight[i] = Math.max(maxRight[i + 1], max);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i ++) {
            int val1 = Math.abs(maxLeft[i] - minRight[i + 1]);
            int val2 = Math.abs(minLeft[i] - maxRight[i + 1]);
            ans = Math.max(ans, Math.max(val1, val2));
        }
        return ans;
    }
}