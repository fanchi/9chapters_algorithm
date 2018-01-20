/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

Have you met this question in a real interview? Yes
Example
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

Challenge 
The replacement must be in-place, do not allocate extra memory.

Tags 
Permutation Array
Related Problems 
Medium Next Permutation II 34 %
Medium Permutation Index II 24 %
Easy Permutation Index 30 %
Medium Permutations II 26 %
*/
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        int pivot = -1;
        for (int i = nums.length - 1; i > 0; i --) {
            if (nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }
        if (pivot == -1) {
            reverse(nums, 0);
            return;
        }
        int partition = nums.length - 1;
        for (int i = nums.length - 1; i > pivot; i --) {
            if (nums[i] > nums[pivot]) {
                partition = i;
                break;
            }
        }
        swap(nums, pivot, partition);
        reverse(nums, pivot + 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start ++;
            end --;
        }
    }
}