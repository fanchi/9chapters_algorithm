/*
Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

Have you met this question in a real interview? Yes
Example
For array [1,2,7,8,5], moving window size k = 3. 
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]

Tags 
Amazon
Related Problems 
Hard Sliding Window Median 18 %
Super Sliding Window Maximum 27 %
Medium Minimum Window Substring 23 %
*/

public class Solution {
    /*
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (i < k - 1) {
                continue;
            }
            if (i == k - 1) {
                ans[i - k + 1] = sum;
            }
            else {
                ans[i - k + 1] = ans[i - k] - nums[i - k] + nums[i];
            }
        }
        return ans;
    }
}