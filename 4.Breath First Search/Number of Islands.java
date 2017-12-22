/*
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.

Have you met this question in a real interview? Yes
Example
Given graph:

[
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [0, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [0, 0, 0, 0, 1]
]
return 3.

Tags 
Zenefits Google Facebook
Related Problems 
Medium Number of Big Islands 19 %
Medium Surrounded Regions 23 %
Hard Number of Islands II 19 %
*/

// union find
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        Union union = new Union(m * n);
        boolean[][] visited = new boolean[m][n];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (!visited[i][j] && grid[i][j]) {
                    for (int k = 0; k < dx.length; k ++) {
                        int newI = i + dx[k], newJ = j + dy[k];
                        if (valid(newI, newJ, m, n) && grid[newI][newJ] && !visited[newI][newJ]) {
                            union.connect(i *n + j, newI * n + newJ);
                        }
                    }
                }
            }
        }
        Set<Integer> parents = new HashSet<>();
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j]) {
                    parents.add(union.find(i * n + j));
                }
            }
        }
        return parents.size();
    }
    private class Union {
        int[] array;
        int n;
        private Union(int n) {
            this.array = new int[n];
            for (int i = 0; i < n; i ++) {
                array[i] = i;
            }
            this.n = n;
        }
        private int find(int i) {
            int parent = array[i];
            while (parent != array[parent]) {
                parent = array[parent];
            }
            return parent;
        }
        private void connect(int i, int j) {
            int parentI = find(i);
            int parentJ = find(j);
            if (parentI != parentJ) {
                array[parentI] = parentJ;
            }
        }
    }
    private boolean valid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
// bfs
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    int ans = 0;
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == true && !visited[i][j]) {
                    bfs(grid, i, j, m, n, visited);
                }
            }
        }
        return ans;
    }
    private void bfs(boolean[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * n + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int position = queue.poll();
            int x = position / n, y = position % n;
            for (int k = 0; k < dx.length; k ++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                if (valid(newX, newY, m, n) && grid[newX][newY] == true && !visited[newX][newY]) {
                    queue.offer(newX * n + newY);
                    visited[newX][newY] = true;
                }
            }
        }
        ans ++;
    }
    private boolean valid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}

// bfs
public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    class Point{
        public int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(boolean[][] grid) {
        int size1 = grid.length;
        if(size1 == 0){
            return 0;
        }
        int size2 = grid[0].length;
        if(size2 == 0){
            return 0;
        }
        Queue<Point> q = new LinkedList<>();
        //Set<Point> visited = new HashSet<>();
        boolean[][] visited = new boolean[size1][size2];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int sum = 0;
        for(int i = 0; i < size1; i++){
            for(int j = 0; j < size2; j++){
                if(grid[i][j] == true && !visited[i][j]){
                Point point = new Point(i, j);
                q.offer(point);
                visited[i][j] = true;
                while(!q.isEmpty()){
                    Point curPoint = q.poll();
                    for(int k = 0; k < dx.length; k++){
                    int x = curPoint.x + dx[k];
                    int y = curPoint.y + dy[k];
                    point = new Point(x, y);
                    if(x >= 0 && x <= size1 - 1 && y >= 0 && y <= size2 - 1 
                        && grid[x][y] == true && !visited[x][y]){
                        q.offer(point);
                        visited[x][y] = true;
                        }//if x, y == 1
                    }//for k
                }//while
                sum ++;
            }//if i,j == 1
            }//for j
        }//for i
        return sum;
    }
}