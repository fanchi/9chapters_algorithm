/*
Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). Originally, the 2D matrix is all 0 which means there is only sea in the matrix. The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after each operator.

 Notice
0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Have you met this question in a real interview? Yes
Example
Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].

return [1,1,2,2].

Tags 
Google Union Find
Related Problems 
Medium Number of Big Islands 19 %
Hard Minimum Spanning Tree 25 %
Medium Connecting Graph 39 %
Medium Surrounded Regions 23 %
Easy Number of Islands 25 %
*/
// TLE
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        if(n <= 0 || m <= 0 || operators == null || operators.length == 0){
            //ans.add(0);
            return ans;
        }
        int[][] grid = new int[n][m];
        for(Point point: operators){
            grid[point.x][point.y] = 1;
            bfs(grid, n, m, ans);
        }
        return ans;
    }
    private void bfs(int[][] grid, int n, int m, List<Integer> ans){
        int num = 0;
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(grid[i][j] == 0 || visited[i][j]){
                    continue;
                }
                Queue<Point> queue = new LinkedList<>();
                queue.offer(new Point(i, j));
                while(!queue.isEmpty()){
                    int size = queue.size();
                    for(int s = 0; s < size; s ++){
                        Point curPoint = queue.poll();
                        for(int k = 0; k < dx.length; k ++){
                            int newX = curPoint.x + dx[k];
                            int newY = curPoint.y + dy[k];
                            if(valid(newX, newY, n, m, grid) && !visited[newX][newY]){
                                queue.offer(new Point(newX, newY));
                                visited[newX][newY] = true;
                            }
                        }
                    }
                }
                num ++;
            }// for j
        }// for i
        ans.add(num);
    }
    private boolean valid(int newX, int newY, int n, int m, int[][] grid){
        if(newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1){
            return true;
        }
        return false;
    }
}

// union find, copied
/**
* 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
* - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
* - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
* - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
* - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
*/ 

public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    int converttoId(int x, int y, int m){
        return x*m + y;
    }
    class UnionFind{
        HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        UnionFind(int n, int m){
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < m; j++) {
                    int id = converttoId(i,j,m);
                    father.put(id, id); 
                }
            }
        }
        int compressed_find(int x){
            int parent =  father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            int temp = -1;
            int fa = x;
            while(fa!=father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, parent) ;
                fa = temp;
            }
            return parent;
                
        }
        
        void union(int x, int y){
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y)
                father.put(fa_x, fa_y);
        }
    }
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        if(operators == null) {
            return ans;
        }
        
        int []dx = {0,-1, 0, 1};
        int []dy = {1, 0, -1, 0};
        int [][]island = new int[n][m];
       
        
        UnionFind uf = new UnionFind(n, m);
        int count = 0;
        
        for(int i = 0; i < operators.length; i++) {
            int x = operators[i].x;
            int y = operators[i].y;
            if(island[x][y] != 1) {
                count ++;
                island[x][y]  = 1;
                int id = converttoId(x,y , m);
                for(int j = 0 ; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1) 
                    {
                        int nid = converttoId(nx, ny, m);
                        
                        int fa = uf.compressed_find(id);
                        int nfa = uf.compressed_find(nid);
                        if(fa != nfa) {
                            count--;
                            uf.union(id, nid);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}