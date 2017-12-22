/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.

As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/
Have you met this question in a real interview? Yes
Example
return a deep copied graph.

Tags 
Breadth First Search Facebook
Related Problems 
Medium Six Degrees 35 %
Easy Clone Binary Tree 46 %
Medium Route Between Two Nodes in Graph 36 %
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        // old, new
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node.label);
        while (!queue.isEmpty()) {
            UndirectedGraphNode oldNode = queue.poll();
            UndirectedGraphNode newNode = new UndirectedGraphNode(oldNode.label);
            map.put(oldNode, newNode);
            for (UndirectedGraphNode neighbor: oldNode.neighbors) {
                if (!visited.contains(neighbor.label)) {
                    queue.offer(neighbor);
                    visited.add(neighbor.label);
                }
            }
        }
        for (UndirectedGraphNode oldNode: map.keySet()) {
            UndirectedGraphNode newNode = map.get(oldNode);
            ArrayList<UndirectedGraphNode> oldNeighbors = oldNode.neighbors;
            for (UndirectedGraphNode oldNeighbor: oldNeighbors) {
                UndirectedGraphNode newNeighbor = map.get(oldNeighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
    }
}