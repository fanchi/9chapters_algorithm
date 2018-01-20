/*
Given a knight in a chessboard n * m (a binary matrix with 0 as empty and 1 as barrier). the knight initialze position is (0, 0) and he wants to reach position (n - 1, m - 1), Knight can only be from left to right. Find the shortest path to the destination position, return the length of the route. Return -1 if knight can not reached.

Have you met this question in a real interview? Yes
Clarification
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x - 1, y + 2)
(x + 2, y + 1)
(x - 2, y + 1)
Example
[[0,0,0,0],
 [0,0,0,0],
 [0,0,0,0]]

Return 3

[[0,0,0,0],
 [0,0,0,0],
 [0,1,0,0]]

Return -1
Tags 
Dynamic Programming Amazon Breadth First Search
Related Problems 
Medium Knight Shortest Path 24%
*/
public class Solution {
    /*
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = {-1, 1, -2, 2};
        int[] dy = {-2, -2, -1, -1};
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i ++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int j = 1; j < n; j ++) {
            for (int i = 0; i < m; i ++) {
                for (int k = 0; k < dx.length; k ++) {
                    int prevX = i + dx[k];
                    int prevY = j + dy[k];
                    if (grid[i][j]) {
                        continue;
                    }
                    if (inBound(prevX, prevY, m, n) && !grid[prevX][prevY] && dp[prevX][prevY] != Integer.MAX_VALUE) {
                        if (dp[prevX][prevY] + 1 < dp[i][j]) {
                            dp[i][j] = dp[prevX][prevY] + 1;
                        }
                    }
                }
            }
        }
        if (dp[m - 1][n - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return dp[m - 1][n - 1];
        }
    }
    private boolean inBound(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}