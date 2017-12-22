/*
Find any position of a target number in a sorted array. Return -1 if target does not exist.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 1 or 2.

For target = 5, return 4 or 5.

For target = 6, return -1.

Challenge 
O(logn) time

Tags 
Binary Search
Related Problems 
Easy Closest Number in Sorted Array 35 %
Easy Last Position of Target 36 %
Easy First Position of Target 33 %
*/
public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }//null check
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }//while
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
        
        // if (nums == null || nums.length == 0) {
        //     return -1;
        // }
        
        // int start = 0, end = nums.length - 1;
        // while (start + 1 < end) {
        //     int mid = start + (end - start) / 2;
        //     if (nums[mid] == target) {
        //         return mid;
        //     } else if (nums[mid] < target) {
        //         start = mid;
        //     } else {
        //         end = mid;
        //     }
        // }
        
        // if (nums[start] == target) {
        //     return start;
        // }
        // if (nums[end] == target) {
        //     return end;
        // }
        // return -1;
    }//findPosition
}//class