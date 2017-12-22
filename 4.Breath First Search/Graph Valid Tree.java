/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 Notice
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Have you met this question in a real interview? Yes
Example
Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Tags 
Depth First Search Zenefits Breadth First Search Google Union Find Facebook
Related Problems 
Medium Connecting Graph 39 %
Medium Connected Component in Undirected Graph 25 %
*/
// return (visited == n)
// Map > graph = initializeGraph(n, edges);
public class Solution {
    /*
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (edges == null) {
            return false;
        }
        int m = edges.length;
        if (n == 1 && m == 0) {
            return true;
        }
        if (m != n - 1) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < m; i ++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            if (graph.containsKey(v1)) {
                graph.get(v1).add(v2);
            }
            else {
                Set<Integer> temp = new HashSet<>();
                temp.add(v2);
                graph.put(v1, temp);
            }
            if (graph.containsKey(v2)) {
                graph.get(v2).add(v1);
            }
            else {
                Set<Integer> temp = new HashSet<>();
                temp.add(v1);
                graph.put(v2, temp);
            }
        }
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            Set<Integer> neighbors = graph.get(node);
            for (int nei: neighbors) {
                if (visited[nei]) {
                    continue;
                }
                queue.offer(nei);
                visited[nei] = true;
            }
        }
        for (int i = 0; i < visited.length; i ++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}