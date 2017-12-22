/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Have you met this question in a real interview? Yes
Example
Given n = 2, prerequisites = [[1,0]]
Return true

Given n = 2, prerequisites = [[1,0],[0,1]]
Return false

Tags 
Amazon Topological Sort Apple Zenefits Breadth First Search
Related Problems 
Hard Course Schedule III 19 %
Medium Course Schedule II 21 %
Medium Topological Sorting 30 %
*/
public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if (numCourses == 1 && (prerequisites == null || prerequisites.length == 0)) {
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> inDegreeHelper = new HashMap<>();
        for (int i = 0; i < numCourses; i ++) {
            map.put(i, new HashSet<>());
            inDegreeHelper.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i ++) {
            int next = prerequisites[i][0];
            int prev = prerequisites[i][1];
            if (next < 0 || next >= numCourses || prev < 0 || prev >= numCourses) {
                return false;
            }
            map.get(prev).add(next);
            inDegreeHelper.get(next).add(prev);
        }
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < inDegree.length; i ++) {
            inDegree[i] = inDegreeHelper.get(i).size();
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i ++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int prev = queue.poll();
            count ++;
            Set<Integer> nexts = map.get(prev);
            for (int next: nexts) {
                inDegree[next] --;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == numCourses;
    }
}