/*
Given an array with positive and negative numbers, find the maximum average subarray which length should be greater or equal to given length k.

 Notice
It's guaranteed that the size of the array is greater or equal to k.

Have you met this question in a real interview? Yes
Example
Given nums = [1, 12, -5, -6, 50, 3], k = 3

Return 15.667 // (-6 + 50 + 3) / 3 = 15.667

Tags 
Subarray Binary Search Google
Related Problems 
Hard Maximum Subarray V 29 %
Medium Maximum Subarray IV 35 %
Easy Maximum Subarray 38 %
*/
/*
前缀和
(sum[i] - sum[j - 1])/(i - j + 1) &gt;= 0.5
(sum[i] - sum[j - 1]) - (i - j + 1) * 0.5 &gt;= 0
bsum[i] = nums[0] - 0.5 + nums[1] - 0.5 + .....
求min_pre的操作，是在for循环的末尾的，它的含义是新计算出来的min_pre是给i+1用的，不是给i用的，所以是i+1-k

没有AC，测试样例[-1,0,1], 3没通过，输出-0.00，期望输出是0.00
*/
public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        int min = nums[0], max = nums[0];
        for (int i = 0; i < nums.length; i ++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        double left = (double)min, right = (double)max;
        double mid = 0.0;
        while (right - left >= 1e-6) {
            mid = (left + right) / 2;
            if (valid(nums, mid, k)) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return left; // note, not return mid, one case is that all elements in nums[] have the same value
    }
    private boolean valid(int[] nums, double mid, int k) {
        double[] prefix = new double[nums.length + 1];
        double prevMin = 0;
        prefix[0] = 0;
        for (int i = 0; i < nums.length; i ++) {
            // i is the index of nums, not prefix[]
            prefix[i + 1] = prefix[i] + nums[i] - mid;
            if (i >= k - 1 && prefix[i + 1] - prevMin > 0) {
                return true;
            }
            if (i >= k - 1) {
                prevMin = Math.min(prevMin, prefix[i + 2 - k]);
            }
        }
        return false;
    }
}