/*
Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
Given nums = [2, 7, 11, 15], target = 24. 
Return 5. 
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25

Tags 
Sort Two Pointers
Related Problems 
Medium Two Sum - BST edtion 27 %
Medium Two Sum - Input array is sorted 47 %
Medium Two Sum - Difference equals to target 26 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Closest to target 43 %
Medium Two Sum - Greater than target 38 %
Easy Two Sum 28 %
*/
public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, ans = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right --;
            }
            else {
                ans += (right - left);
                left ++;
            }
        }
        return ans;
    }
}