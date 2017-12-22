/*
Given a 2D grid, each cell is either a wall 2, a zombie 1 or people 0 (the number zero, one, two).Zombies can turn the nearest people(up/down/left/right) into zombies every day, but can not through wall. How long will it take to turn all people into zombies? Return -1 if can not turn all people into zombies.

Have you met this question in a real interview? Yes
Example
Given a matrix:

0 1 2 0 0
1 0 0 2 1
0 1 0 0 0
return 2

Tags 
Breadth First Search
Related Problems 
Hard Build Post Office II 27 %
*/
public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    queue.offer(i * n + j);
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days ++;
            for (int i = 0; i < size; i ++) {
                int p = queue.poll();
                for (int k = 0; k < dx.length; k ++) {
                    int newX = p / n + dx[k];
                    int newY =p % n + dy[k];
                    if (valid(newX, newY, m, n, grid)) {
                        grid[newX][newY] = 1;
                        queue.offer(newX * n + newY);
                    }
                }
            }
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        return days - 1;
    }
    private boolean valid(int x, int y, int m, int n, int[][] grid) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0;
    }
}