/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Have you met this question in a real interview? Yes
Example
Given an example n=3 , 1+1+1=2+1=1+2=3

return 3

Tags 
Dynamic Programming
Related Problems 
Naive Fibonacci 24 %
Medium House Robber 33 %
*/
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }
}