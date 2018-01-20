/*
Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. Please return the number of pairs.

Have you met this question in a real interview? Yes
Example
Given nums = [1,1,2,45,46,46], target = 47
return 2

1 + 46 = 47
2 + 45 = 47

Tags 
Two Pointers Hash Table
Related Problems 
Medium Two Sum - Input array is sorted 47 %
Medium Two Sum - Difference equals to target 26 %
Medium Two Sum - Less than or equal to target 39 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Greater than target 38 %
Easy Two Sum 28 %
*/
public class Solution {
    /*
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int ans = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left ++;
            }
            else if (sum > target) {
                right --;
            }
            else {
                ans ++;
                left ++;
                right --;
                while (left < right && nums[left] == nums[left - 1]) {
                    left ++;
                }
                while (left < right && nums[right] == nums[right + 1]) {
                    right --;
                }
            }
        }
        return ans;
    }
}