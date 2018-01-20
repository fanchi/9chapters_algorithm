/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

Have you met this question in a real interview? Yes
Example
For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

Tags 
Dynamic Programming LinkedIn Subarray
Related Problems 
Medium Best Time to Buy and Sell Stock 41 %
Medium Maximum Subarray Difference 24 %
Easy Minimum Subarray 38 %
Medium Maximum Subarray II 26 %
*/
public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        int[] mins = new int[nums.length];
        int[] maxs = new int[nums.length];
        mins[0] = nums[0];
        maxs[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] >= 0) {
                mins[i] = Math.min(mins[i - 1] * nums[i], nums[i]);
                maxs[i] = Math.max(maxs[i - 1] * nums[i], nums[i]);
            }
            else {
                mins[i] = Math.min(maxs[i - 1] * nums[i], nums[i]);
                maxs[i] = Math.max(mins[i - 1] * nums[i], nums[i]);
            }
            ans = Math.max(ans, maxs[i]);
        }
        return ans;
    }
}