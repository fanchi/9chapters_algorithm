/*
Given an array of integers, find two non-overlapping subarrays which have the largest sum.
The number in each subarray should be contiguous.
Return the largest sum.

 Notice
The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], they both have the largest sum 7.

Challenge 
Can you do it in time complexity O(n) ?

Tags 
Greedy Enumeration Array LintCode Copyright Subarray Forward-Backward Traversal
Related Problems 
Hard Maximum Subarray V 29 %
Medium Maximum Subarray IV 35 %
Medium Maximum Product Subarray 30 %
Medium Best Time to Buy and Sell Stock III 27 %
Hard Maximum Subarray III 25 %
*/

/*
因为 两个subarray 一定不重叠

所以必定存在一条分割线

分开这两个 subarrays

所以 最后的部分里：

max = Integer.MIN_VALUE;

    for(int i = 0; i < size - 1; i++){

        max = Math.max(max, left[i] + right[i + 1]);

    }

    return max;
这里是在枚举 这条分割线的位置

然后 left[] 和 right[] 里分别存的是，某个位置往左的 maximum subarray 和往右的 maximum subarray
*/

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        maxLeft[0] = nums.get(0);
        maxRight[len - 1] = nums.get(len - 1);
        int max = nums.get(0);
        for (int i = 1; i < len; i ++) {
            max = Math.max(max + nums.get(i), nums.get(i));
            maxLeft[i] = Math.max(maxLeft[i - 1], max);
        }
        max = nums.get(len - 1);
        for (int i = len - 2; i >= 0; i --) {
            max = Math.max(max + nums.get(i), nums.get(i));
            maxRight[i] = Math.max(maxRight[i + 1], max);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i ++) {
            ans = Math.max(ans, maxLeft[i] + maxRight[i + 1]);
        }
        return ans;
    }
}