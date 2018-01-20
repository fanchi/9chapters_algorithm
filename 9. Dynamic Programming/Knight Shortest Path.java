/*
Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route. 
Return -1 if knight can not reached.

 Notice
source and destination must be empty.
Knight can not enter the barrier.

Have you met this question in a real interview? Yes
Clarification
If the knight is at (x, y), he can get to the following positions in one step:

(x + 1, y + 2)
(x + 1, y - 2)
(x - 1, y + 2)
(x - 1, y - 2)
(x + 2, y + 1)
(x + 2, y - 1)
(x - 2, y + 1)
(x - 2, y - 1)
Example
[[0,0,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 2

[[0,1,0],
 [0,0,0],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return 6

[[0,1,0],
 [0,0,1],
 [0,0,0]]
source = [2, 0] destination = [2, 2] return -1
Tags 
Breadth First Search
Related Problems 
Medium Knight Shortest Path II 28 %
Medium Search Graph Nodes 45 %
*/

/*
steps[][]记录
no need to use visited
*/
/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid.length == 0 || source == null || destination == null) {
            return -1;
        }
        int m = grid.length, n = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        int[][] steps = new int[m][n];
        for (int i = 0; i < m; i ++) {
            Arrays.fill(steps[i], Integer.MAX_VALUE);
        }
        steps[source.x][source.y] = 0;
        queue.offer(source);
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        while (!queue.isEmpty()) {
            Point curP = queue.poll();
            for (int k = 0; k < dx.length; k ++) {
                int newX = curP.x + dx[k];
                int newY = curP.y + dy[k];
                if (valid(newX, newY, m, n) && !grid[newX][newY] && steps[curP.x][curP.y] + 1 < steps[newX][newY]) {
                    Point p = new Point(newX, newY);
                    queue.offer(p);
                    steps[newX][newY] = steps[curP.x][curP.y] + 1;
                }
            }
        }
        return steps[destination.x][destination.y] == Integer.MAX_VALUE ? -1 : steps[destination.x][destination.y];
    }
    private boolean valid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}