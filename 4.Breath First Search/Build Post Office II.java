/*
Given a 2D grid, each cell is either a wall 2, an house 1 or empty 0 (the number zero, one, two), find a place to build a post office so that the sum of the distance from the post office to all the houses is smallest.

Return the smallest sum of distance. Return -1 if it is not possible.

 Notice
You cannot pass through wall and house, but can pass through empty.
You only build post office on an empty.
Have you met this question in a real interview? Yes
Example
Given a grid:

0 1 0 0 0
1 0 0 2 1
0 1 0 0 0
return 8, You can build at (1,1). (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)

Challenge 
Solve this problem within O(n^3) time.

Tags 
Zenefits Breadth First Search Google
Related Problems 
Medium Zombie in Matrix 29 %
Hard Build Post Office
*/
// BFS from each house to all possible empties.
// For each empty, record visited time and total steps from houses. If the visited time == numer of houses, it means it is accessible by all // houses.
// Return the smallest step, which correspond to the empty that has the smallest total steps by all houses.
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    class Point{
        public int x;
        public int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int shortestDistance(int[][] grid) {
        // Write your code here
        int m = grid.length;
        if(m == 0)
            return -1;
        int n = grid[0].length;
        if(n == 0)
            return -1;
        //get all 1 points and 0 points
        ArrayList<Point> listOnes = new ArrayList<>();
        ArrayList<Point> listZeros = new ArrayList<>();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 1)
                    listOnes.add(new Point(i, j));
                if(grid[i][j] == 0)
                    listZeros.add(new Point(i, j));
            }
        }//for i
        //record the visited times and sum of steps for every 0 points
        int[][] timeVisited = new int[m][n];
        int[][] sumSteps = new int[m][n];
        // for(int i = 0; i < m; i ++){
        //     Arrays.fill(timeVisited[i], 0);
        //     Arrays.fill(sumSteps[i], Integer.MAX_VALUE);
        // }
        //bfs for 1 points and update visited and sumSteps
        for(int index = 0; index < listOnes.size(); index ++)
            bfs(listOnes.get(index), grid, timeVisited, sumSteps);
        //judge for every 0 point
        int minSteps = Integer.MAX_VALUE;
        for(Point p: listZeros){
            if(timeVisited[p.x][p.y] != listOnes.size())
                continue;
            if(sumSteps[p.x][p.y] < minSteps)
                minSteps = sumSteps[p.x][p.y];
        }
        if(minSteps == Integer.MAX_VALUE)
            return -1;
        return minSteps;
    }
    private void bfs(Point start, int[][] grid, int[][] timeVisited, int[][] sumSteps){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.offer(start);
        visited[start.x][start.y] = true;
        int steps = 0;
        while(!q.isEmpty()){
            steps ++;
            int numInQ = q.size();
            for(int temp = 0; temp < numInQ; temp ++){
                Point curP = q.poll();
                int curX = curP.x, curY = curP.y;
                for(int k = 0; k < dx.length; k ++){
                int newX = curX + dx[k];
                int newY = curY + dy[k];
                if(!isValid(newX, newY, grid.length, grid[0].length)
                    || grid[newX][newY] != 0 || visited[newX][newY])
                    continue;
                visited[newX][newY] = true;
                q.offer(new Point(newX, newY));
                timeVisited[newX][newY] ++;
                sumSteps[newX][newY] += steps;
                }//for k
            }//for temp
        }//while
    }
    private boolean isValid(int x, int y, int m, int n){
        if(x < 0 || x > m -1 || y < 0 || y > n - 1)
            return false;
        return true;
    }
}