/*
Find the number connected component in the undirected graph. Each node in the graph contains a label and a list of its neighbors. (a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, and which is connected to no additional vertices in the supergraph.)

 Notice
Each connected component should sort by label.

Have you met this question in a real interview? Yes
Clarification
Learn more about representation of graphs

Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

Tags 
Breadth First Search Union Find
Related Problems 
Medium Graph Valid Tree 27 %
*/
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (nodes == null || nodes.size() == 0) {
            return ans;
        }
        Set<Integer> visited = new HashSet<>();
        for (UndirectedGraphNode node: nodes) {
            if (!visited.contains(node.label)) {
                bfs(ans, node, visited);
            }
        }
        return ans;
    }
    private void bfs(List<List<Integer>> ans, UndirectedGraphNode node, Set<Integer> visited) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.add(node.label);
        List<Integer> tempAns = new ArrayList<>();
        while (!queue.isEmpty()) {
            UndirectedGraphNode curNode = queue.poll();
            tempAns.add(curNode.label);
            for (UndirectedGraphNode neighbor: curNode.neighbors) {
                if (!visited.contains(neighbor.label)) {
                    queue.offer(neighbor);
                    visited.add(neighbor.label);
                }
            }
        }
        if (tempAns.size() > 0) {
            Collections.sort(tempAns);
            ans.add(tempAns);
        }
    }
}