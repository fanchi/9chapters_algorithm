/*
Given an array of integers, find how many pairs in the array such that their sum is bigger than a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)

Challenge 
Do it in O(1) extra space and O(nlogn) time.

Tags 
Sort Two Pointers
Related Problems 
Medium Two Sum - Input array is sorted 47 %
Medium Two Sum - Difference equals to target 26 %
Medium Two Sum - Less than or equal to target 39 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Closest to target 43 %
Easy Two Sum 28 %
*/
public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                ans += right - left;
                right --;
            }
            else {
                left ++;
            }
        }
        return ans;
    }
}