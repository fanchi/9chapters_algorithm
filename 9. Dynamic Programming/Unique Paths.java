/*
A robot is located at the top-left corner of a m x n grid.

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.

How many possible unique paths are there?

 Notice
m and n will be at most 100.

Have you met this question in a real interview? Yes
Example
Given m = 3 and n = 3, return 6.
Given m = 4 and n = 5, return 35.

Tags 
Dynamic Programming Array
Related Problems 
Hard Unique Paths III 22 %
*/
public class Solution {
    /*
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] dp = new int[m][n];
        for (int i = 1; i <= m - 1; i ++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= n - 1; j ++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m - 1; i ++) {
            for (int j = 1; j <= n - 1; j ++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}