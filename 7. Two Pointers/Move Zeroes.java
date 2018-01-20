/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Notice
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Have you met this question in a real interview? Yes
Example
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Tags 
Array Two Pointers
Related Problems 
Easy Remove Element 30 %
*/
public class Solution {
    /*
     * @param nums: an integer array
     * @return: 
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = -1, i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                swap(nums, i, ++left);
            }
            i ++;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}