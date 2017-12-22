/*
Six degrees of separation is the theory that everyone and everything is six or fewer steps away, by way of introduction, from any other person in the world, so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.

Given a friendship relations, find the degrees of two people, return -1 if they can not been connected by friends of friends.

Have you met this question in a real interview? Yes
Example
Gien a graph:

1------2-----4
 \          /
  \        /
   \--3--/
{1,2,3#2,1,4#3,1,4#4,2,3} and s = 1, t = 4 return 2

Gien a graph:

1      2-----4
             /
           /
          3
{1#2,4#3,4#4,2,3} and s = 1, t = 4 return -1

Tags 
Microsoft
Related Problems 
Medium Clone Graph 29 %
*/
// 求最短路径：
// 方法1. 分层遍历
// 方法2. 记录，如果小于则继续
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (graph == null || s == null || t == null) {
            return -1;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        int ans = 0;
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans ++;
            for (int i = 0; i < size; i ++) {
                UndirectedGraphNode node = queue.poll();
                if (node == t) {
                    return ans - 1;
                }
                for (UndirectedGraphNode neighbor: node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
        return -1;
    }
}

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if(graph == null || s == null || t == null){
            return -1;
        }
        Map<Integer, Integer> steps = new HashMap<>();
        for(UndirectedGraphNode node: graph){
            steps.put(node.label, Integer.MAX_VALUE);
        }
        Set<Integer> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s.label);
        steps.put(s.label, 0);
        while(!queue.isEmpty()){
            UndirectedGraphNode curNode = queue.poll();
            for(UndirectedGraphNode nb: curNode.neighbors){
                if(!visited.contains(nb.label) && steps.get(curNode.label) + 1 < steps.get(nb.label)){
                    queue.offer(nb);
                    visited.add(nb.label);
                    steps.put(nb.label, steps.get(curNode.label) + 1);
                }
            }
        }//while
        if(steps.get(t.label) == Integer.MAX_VALUE){
            return -1;
        }
        return steps.get(t.label);
    }
}