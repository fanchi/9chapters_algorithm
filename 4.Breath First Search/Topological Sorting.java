/*
Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

 Notice
You can assume that there is at least one topological order in the graph.

Have you met this question in a real interview? Yes
Clarification
Learn more about representation of graphs

Example
For graph as follow:

picture

The topological order can be:

[0, 1, 2, 3, 4, 5]
[0, 2, 3, 1, 5, 4]
...
Challenge 
Can you do it in both BFS and DFS?

Tags 
LintCode Copyright Geeks for Geeks Topological Sort Depth First Search Breadth First Search
Related Problems 
Medium Course Schedule 23 %
Medium Course Schedule II 21 %
Medium Sequence Reconstruction 19 %
*/
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        if (graph == null || graph.size() == 0) {
            return ans;
        }
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (DirectedGraphNode node: graph) {
            ArrayList<DirectedGraphNode> neighbors = node.neighbors;
            for (DirectedGraphNode nei: neighbors) {
                int key = nei.label;
                if (inDegree.containsKey(key)) {
                    inDegree.put(key, inDegree.get(key) + 1);
                }
                else {
                    inDegree.put(key, 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node: graph) {
            if (!inDegree.containsKey(node.label)) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            ans.add(node);
            ArrayList<DirectedGraphNode> neighbors = node.neighbors;
            for (DirectedGraphNode nei: neighbors) {
                int key = nei.label;
                inDegree.put(key, inDegree.get(key) - 1);
                if (inDegree.get(key) == 0) {
                    queue.offer(nei);
                }
            }
        }
        return ans;
    }
}