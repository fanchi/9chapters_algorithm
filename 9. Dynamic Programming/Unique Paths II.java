/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Notice
m and n will be at most 100.

Have you met this question in a real interview? Yes
Example
For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Tags 
Dynamic Programming Array
Related Problems 
Hard Unique Paths III 22 %
*/
public class Solution {
    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i ++) {
            if (obstacleGrid[i][0] != 1 && obstacleGrid[i - 1][0] != 1) {
                dp[i][0] = 1;
            }
            else {
                break;
            }
        }
        for (int j = 1; j < n; j ++) {
            if (obstacleGrid[0][j] != 1 && obstacleGrid[0][j - 1] != 1) {
                dp[0][j] = 1;
            }
            else {
                break;
            }
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (obstacleGrid[i - 1][j] != 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (obstacleGrid[i][j - 1] != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}