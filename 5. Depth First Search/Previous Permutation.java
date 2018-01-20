/*
Given a list of integers, which denote a permutation.

Find the previous permutation in ascending order.

 Notice
The list may contains duplicate integers.

Have you met this question in a real interview? Yes
Example
For [1,3,2,3], the previous permutation is [1,2,3,3]

For [1,2,3,4], the previous permutation is [4,3,2,1]

Tags 
Permutation LintCode Copyright
Related Problems 
Medium Permutation Sequence 28 %
Easy Permutation Index 30 %
Medium Next Permutation 25 %
*/
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() <= 1) {
            return nums;
        }
        int pivot = -1;
        for (int j = nums.size() - 1; j > 0; j --) {
            if (nums.get(j - 1) > nums.get(j)) {
                pivot = j - 1;
                break;
            }
        }
        if (pivot == -1) {
            Collections.reverse(nums);
            return nums;
        }
        int partition = nums.size() - 1;
        for (int j = nums.size() - 1; j > pivot; j --) {
            if (nums.get(j) < nums.get(pivot)) {
                partition = j;
                break;
            }
        }
        swap(nums, pivot, partition);
        reverse(nums, pivot + 1);
        return nums;
    }
    private void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
    private void reverse(List<Integer> nums, int i) {
        int start = i, end = nums.size() - 1;
        while (start < end) {
            swap(nums, start ++, end --);
        }
    }
}