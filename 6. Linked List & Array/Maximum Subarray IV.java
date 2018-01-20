/*
Given an integer arrays, find a contiguous subarray which has the largest sum and length should be greater or equal to given length k.
Return the largest sum, return 0 if there are fewer than k elements in the array.

 Notice
Ensure that the result is an integer type.

Have you met this question in a real interview? Yes
Example
Given the array [-2,2,-3,4,-1,2,1,-5,3] and k = 5, the contiguous subarray [2,-3,4,-1,2,1] has the largest sum = 5.

Tags 
Array Subarray Facebook
Related Problems 
Super Maximum Subarray VI 21 %
Hard Maximum Subarray V 29 %
Medium Maximum Average Subarray 18 %
Hard Maximum Subarray III 25 %
Medium Maximum Subarray II 26 %
Easy Maximum Subarray 38 %
*/
public class Solution {
    /*
     * @param nums: an array of integer
     * @param k: an integer
     * @return: the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k) {
            return 0;
        }
        int sum = 0, leftSum = 0, leftMin = 0, ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i ++) {
            if (i < k - 1) {
                sum += nums[i];
            }
            else if (i == k - 1) {
                sum += nums[i];
                ans = Math.max(ans, sum);
            }
            else {
                sum += nums[i];
                leftSum += nums[i - k];
                leftMin = Math.min(leftMin, leftSum);
                ans = Math.max(ans, sum - leftMin);
            }
        }
        return ans;
    }
}