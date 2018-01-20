/*
Partition an unsorted integer array into three parts:

The front part < low
The middle part >= low & <= high
The tail part > high
Return any of the possible solutions.

 Notice
low <= high in all testcases.

Have you met this question in a real interview? Yes
Example
Given [4,3,4,1,2,3,1,2], and low = 2 and high = 3.

Change to [1,1,2,3,2,3,4,4].

([1,1,2,2,3,3,4,4] is also a correct answer, but [1,2,1,2,3,3,4,4] is not)

Challenge 
Do it in place.
Do it in one pass (one loop).
Related Problems 
Hard Folding Array 38 %
Medium Sort Colors 36 %
Medium Partition Array 30 %
*/
public class Solution {
    /*
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: 
     */
    public void partition2(int[] nums, int low, int high) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length && left <= right; i ++) {
            if (nums[i] < low) {
                swap(nums, i, left ++);
            }
            if (nums[i] > high) {
                swap(nums, i, right --);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}