/*
Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero, one), find the place to build a post office, the distance that post office to all the house sum is smallest. Return the smallest distance. Return -1 if it is not possible.

 Notice
You can pass through house and empty.
You only build post office on an empty.
Have you met this question in a real interview? Yes
Example
Given a grid:

0 1 0 0
1 0 1 1
0 1 0 0
return 6. (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)

Tags 
Sort Binary Search
Related Problems 
Hard Build Post Office II 27 %
*/
// use the same method with Post Office II, the only difference is that "1" is allowed to pass in this code.
// time limit exceeded
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    private class Point{
        private int x, y;
        private Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        if(n == 0){
            return -1;
        }
        Set<Point> zeros = new HashSet<>();
        Set<Point> ones = new HashSet<>();
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 0){
                    zeros.add(new Point(i, j));
                }
                if(grid[i][j] == 1){
                    ones.add(new Point(i, j));
                }
            }
        }
        // Map<Point, Integer> timeVisited = new HashMap<>();
        // Map<Point, Integer> steps = new HashMap<>();
        int[][] timeVisited = new int[m][n];
        int[][] sumSteps = new int[m][n];
        // for(Point point: zeros){
        //     //timeVisited.put(point, 0);
        //     timeVisited[point.x][point.y] = 0;
        // }
        for(Point point: ones){
            //steps.put(point, 0);
            //steps[point.x][point.y] = 0;
            bfs(point, grid, timeVisited, sumSteps);
        }
        int minStep = Integer.MAX_VALUE;
        for(Point point: zeros){
            if(timeVisited[point.x][point.y] != ones.size()){
                System.out.println(timeVisited[point.x][point.y]);
                continue;
            }
            minStep = Math.min(minStep, sumSteps[point.x][point.y]);
        }
        if(minStep == Integer.MAX_VALUE){
            return -1;
        }
        return minStep;
    }
    private void bfs(Point point, int[][] grid, int[][] timeVisited, int[][] sumSteps){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        int[] dm = {-1, 1, 0, 0};
        int[] dn = {0, 0, -1, 1};
        boolean[][] visited = new boolean[m][n];
        queue.offer(point);
        visited[point.x][point.y] = true;
        int steps = 0;
        while(!queue.isEmpty()){
            steps ++;
            int size = queue.size();
            for(int t = 0; t < size; t ++){
                Point curPoint = queue.poll();
                for(int k = 0; k < dm.length; k ++){
                    int newX = curPoint.x + dm[k];
                    int newY = curPoint.y + dn[k];
                    if(valid(newX, newY, m, n, grid) && !visited[newX][newY]){
                        Point newPoint = new Point(newX, newY);
                        queue.offer(newPoint);
                        visited[newX][newY] = true;
                        timeVisited[newX][newY] ++;
                        sumSteps[newX][newY] += steps;
                    }
                }
            }//for t, bfs by layer
        }
    }
    private boolean valid(int newM, int newN, int m, int n, int[][] grid){
        //if(newM >= 0 && newM < m && newN >= 0 && newN < n && grid[newM][newN] != 1){
        if(newM >= 0 && newM < m && newN >= 0 && newN < n){
            return true;
        }
        return false;
    }
}

// copied
/**
* 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
* - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
* - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
* - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
* - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
*/ 

// 方法一 
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        int n = grid.length;
        if (n == 0)
            return -1;

        int m = grid[0].length;
        if (m == 0)
            return -1;

        List<Integer> sumx = new ArrayList<Integer>();
        List<Integer> sumy = new ArrayList<Integer>();
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
        
        Collections.sort(x);
        Collections.sort(y);

        int total = x.size();

        sumx.add(0);
        sumy.add(0);
        for (int i = 1; i <= total; ++i) {
            sumx.add(sumx.get(i-1) + x.get(i-1));
            sumy.add(sumy.get(i-1) + y.get(i-1));
        }

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                if (grid[i][j] == 0) {
                    int cost_x = get_cost(x, sumx, i, total);
                    int cost_y = get_cost(y, sumy, j, total);
                    if (cost_x + cost_y < result)
                        result = cost_x + cost_y;
                }

        return result;
    }

    public int get_cost(List<Integer> x, List<Integer> sum, int pos, int n) {
        if (n == 0)
            return 0;
        if (x.get(0) > pos)
            return sum.get(n) - pos * n;

        int l = 0, r = n - 1;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (x.get(mid) <= pos)
                l = mid;
            else
                r = mid - 1;
        }
        
        int index = 0;
        if (x.get(r) <= pos)
            index = r;
        else
            index = l;
        return sum.get(n) - sum.get(index + 1) - pos * (n - index - 1) + 
               (index + 1) * pos - sum.get(index + 1);
    }
}

// 方法二
public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        int row = grid.length, column = grid[0].length;
        if(row == 0 || column == 0 || !haveZero(grid,row,column)) {
        	return -1;
        }

        int[] rowSum = new int[row];
        int[] columnSum = new int[column]; 
        for(int i = 0; i < row; i++)
        	for(int j = 0; j < column; j++)
        		if(grid[i][j] == 1) {
        			rowSum[i]++;
        			columnSum[j]++;
        		}

        int[] ansRow = new int[row];
        int[] ansColumn = new int[column];
        getSumDistance(rowSum,row,ansRow);
        getSumDistance(columnSum,column,ansColumn);

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++)
        	for(int j = 0; j < column; j++)
        		if(grid[i][j] == 0 && ans > ansRow[i] + ansColumn[j]) {
        			ans = ansRow[i] + ansColumn[j];
        		}
        return ans;
    }

    void getSumDistance(int[] a,int n,int[] ans) {
    	int[] prefixSum1 = new int[n];
    	int[] prefixSum2 = new int[n];
    	/*
    	第一阶段，处理前缀。
    	prefixSum1记录数组 a 的前缀和，即:prefixSum1[i]=a[0]+a[1]+..+a[i].
    	prefixSum2记录数组 prefixSum1 前缀和，prefixSum2即为前 i 个点到第 i 个点的代价和。
    	*/
    	prefixSum1[0] = a[0];
    	for(int i = 1; i < n; i++) {
    		prefixSum1[i] = prefixSum1[i - 1] + a[i];
    	}
    	prefixSum2[0] = 0;
    	for(int i = 1; i < n; i++) {
    		prefixSum2[i] = prefixSum2[i - 1] + prefixSum1[i - 1];
     	}

     	for(int i = 0; i < n; i++) {
     		ans[i] = prefixSum2[i];
     	}

    	/*
    	第二阶段，处理后缀。
    	prefixSum1记录数组 a 的后缀和，即:prefixSum1[i]=a[n-1]+a[n-2]+..+a[i].
    	prefixSum2记录数组 prefixSum1 的后缀和，prefixSum2即为 i 之后的点到第 i 个点的代价和。
    	*/
    	prefixSum1[n - 1] = a[n - 1];
    	for(int i = n - 2; i >= 0; i--) {
    		prefixSum1[i] = prefixSum1[i + 1] + a[i];
    	}
    	prefixSum2[n - 1] =0;
    	for(int i = n - 2; i >= 0; i--) {
    		prefixSum2[i] = prefixSum2[i + 1] + prefixSum1[i + 1];
     	}

     	for(int i = 0; i < n; i++) {
     		ans[i] += prefixSum2[i];
     	}

     	/*
     	ans[i] 即为a数组中所有点到第 i 点的代价和
     	*/
    }

    boolean haveZero(int[][] grid, int row, int column) {
    	for(int i = 0; i < row; i++) {
    		for(int j = 0; j < column; j++){
    			if(grid[i][j] == 0) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
}