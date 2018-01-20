/*
Given an array of integers, remove the duplicate numbers in it.

You should:
1. Do it in place in the array.
2. Move the unique numbers to the front of the array.
3. Return the total number of the unique numbers.

 Notice
You don't need to keep the original order of the integers.

Have you met this question in a real interview? Yes
Example
Given nums = [1,3,1,4,4,2], you should:

Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
Return the number of unique integers in nums => 4.
Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.

Challenge 
Do it in O(n) time complexity.
Do it in O(nlogn) time without extra space.
Tags 
Sort Hash Table
Related Problems 
*/

/*
two points:
one left, one i; copy to the left if find a new number, before copy, left move to the right for one position
Space: O(1), for sorting.
Time: O(nlogn) + O(n) = O(nlogn)
*/

public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, i = 0;
        while (i < nums.length) {
            if (nums[i] == nums[left]) {
                i ++;
                continue;
            }
            swap(nums, i, ++left);
            i ++;
        }
        return left + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

////////////
public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            set.add(nums[i]);
        }
        int ind = 0;
        for (int val: set) {
            nums[ind ++] = val;
        }
        return ind;
    }
}