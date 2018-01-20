/*
Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.

Have you met this question in a real interview? Yes
Example
Given array nums = [-1, 2, 1, -4], and target = 4.

The minimum difference is 1. (4 - (2 + 1) = 1).

Challenge 
Do it in O(nlogn) time complexity.

Tags 
Sort Two Pointers
Related Problems 
Medium Two Sum - Input array is sorted 47 %
Medium Two Sum - Less than or equal to target 39 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Greater than target 38 %
Medium 3Sum Closest 31 %
Easy Two Sum 28 %
*/
public class Solution {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return target;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return 0;
            }
            else if (sum < target) {
                left ++;
                ans = Math.min(ans, target - sum);
            }
            else {
                right --;
                ans = Math.min(ans, sum - target);
            }
        }
        return ans;
    }
}