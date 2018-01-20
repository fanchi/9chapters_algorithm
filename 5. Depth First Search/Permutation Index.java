/*
Given a permutation which contains no repeated number, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Have you met this question in a real interview? Yes
Example
Given [1,2,4], return 1.

Related Problems 
Medium Next Permutation II 34 %
Medium Previous Permutation 27 %
*/
public class Solution {
    /*
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        // write your code here
        if (A == null || A.length <= 1) {
            return 0;
        }
        // find the number of numbers that are smaller than current number
        long ans = 1;
        for (int i = 0; i < A.length; i ++) {
            int count = getCount(A, i);
            ans += factorial(A.length - 1 - i) * (long)count;
        }
        return ans;
    }
    private int getCount(int[] nums, int i) {
        int ans = 0;
        for (int j = i + 1; j < nums.length; j ++) {
            if (nums[j] <= nums[i]) {
                ans ++;
            }
        }
        return ans;
    }
    private long factorial(int val) {
        long ans = 1;
        for (int i = 1; i <= val; i ++) {
            ans *= i;
        }
        return ans;
    }
}