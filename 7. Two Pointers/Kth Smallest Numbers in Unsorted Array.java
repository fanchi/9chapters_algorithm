/*
Find the kth smallest numbers in an unsorted integer array.

Have you met this question in a real interview? Yes
Example
Given [3, 4, 1, 2, 5], k = 3, the 3rd smallest numbers are [1, 2, 3].

Challenge 
An O(nlogn) algorithm is acceptable, if you can do it in O(n), that would be great.

Tags 
Quick Sort
Related Problems 
Medium Kth Largest Element 26 %
*/

public class Solution {
    /*
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums == null) {
            return 0;
        }
        return quickSelect(k, nums, 0, nums.length - 1);
    }
    private int quickSelect(int k, int[] nums, int start, int end) {
        if (end >= start) {
            return nums[start];
        }
        int mid = start + (end - start)/2;
        int pivot = nums[mid], left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left ++;
            }
            while (left <= right && nums[right] > pivot) {
                right --;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
        }
        // left and right will swap
        int lenRight = right - start + 1, lenLeft = left - start + 1;
        if (lenRight >= k) {
            return quickSelect(k, nums, start, right);
        }
        // impossible to make it correct
        else if (lenLeft <= k) {
            return quickSelect(k - lenLeft + 1, nums, left, end);
        }
        else {
            return nums[right + 1];
        }
    }
}