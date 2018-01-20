/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 Notice
You may assume that each input would have exactly one solution.

Have you met this question in a real interview? Yes
Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]

Tags 
Array Two Pointers Amazon Hash Table
Related Problems 
Medium Two Sum - BST edtion 27 %
Medium Two Sum - Difference equals to target 26 %
Medium Two Sum - Less than or equal to target 39 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Closest to target 43 %
Medium Two Sum - Greater than target 38 %
Easy Two Sum 28 %
*/
public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                break;
            }
            else if (nums[left] + nums[right] < target) {
                left ++;
            }
            else {
                right --;
            }
        }
        int[] ans = new int[2];
        ans[0] = left + 1;
        ans[1] = right + 1;
        return ans;
    }
}