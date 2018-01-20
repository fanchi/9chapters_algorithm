/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

 Notice
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Have you met this question in a real interview? Yes
Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Tags 
Dynamic Programming
Related Problems 
Easy Minimum Path Sum 35 %
*/
public class Solution {
    /*
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int m = triangle.length;
        int n = triangle[m - 1].length;
        int[][] dp = new int[2][n];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < m; i ++) {
            dp[i % 2][0] = dp[(i - 1) % 2][0] + triangle[i][0];
            dp[i % 2][i] = dp[(i - 1) % 2][i - 1] + triangle[i][i];
            for (int j = 1; j < i; j ++) {
                dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]) + triangle[i][j];
            }
        }
        int ans = dp[(m - 1) % 2][0];
        for (int i = 0; i < dp[(m - 1) % 2].length; i ++) {
            ans = Math.min(ans, dp[(m - 1) % 2][i]);
        }
        return ans;
    }
}