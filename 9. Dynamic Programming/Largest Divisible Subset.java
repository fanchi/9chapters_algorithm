/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

 Notice
If there are multiple solutions, return any subset is fine.

Have you met this question in a real interview? Yes
Example
Given nums = [1,2,3], return [1,2] or [1,3]

Given nums = [1,2,4,8], return [1,2,4,8]

Tags 
Dynamic Programming
Related Problems 
Medium Longest Increasing Subsequence 30 %
*/
public class Solution {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        // number, prev
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = -1;
        for (int i = 1; i < dp.length; i ++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
            for (int j = i - 1; j >= 0; j --) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j][0] + 1 > dp[i][0]) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = j;
                    }
                }
            }
        }
        int ind = 0, max = 1;
        for (int i = 0; i < dp.length; i ++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
                ind = i;
            }
        }
        ans.add(nums[ind]);
        int prev = dp[ind][1];
        while (prev != -1) {
            ans.add(nums[prev]);
            prev = dp[prev][1];
        }
        // Collections.reverse(ans);
        return ans;
    }
}