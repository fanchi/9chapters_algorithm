/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Have you met this question in a real interview? Yes
Example
Given n = 2, prerequisites = [[1,0]]
Return [0,1]

Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
Return [0,1,2,3] or [0,2,1,3]

Tags 
Amazon Topological Sort Zenefits Breadth First Search Facebook
Related Problems 
Hard Course Schedule III 19 %
Medium Course Schedule 23 %
Medium Sequence Reconstruction 19 %
Medium Topological Sorting 30 %
*/
public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        if (numCourses < 1 || prerequisites == null) {
            return new int[0];
        }
        if (prerequisites.length == 0) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < ans.length; i ++) {
                ans[i] = i;
            }
            return ans;
        }
        // prev -> next
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i ++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i ++) {
            int next = prerequisites[i][0], prev = prerequisites[i][1];
            map.get(prev).add(next);
        }
        int[] inDegrees = new int[numCourses];
        for (int prev: map.keySet()) {
            Set<Integer> nexts = map.get(prev);
            for (int next: nexts) {
                inDegrees[next] ++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i ++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        ArrayList<Integer> ansList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int prev = queue.poll();
            ansList.add(prev);
            Set<Integer> nexts = map.get(prev);
            for (int next: nexts) {
                inDegrees[next] --;
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        // 这一步容易忘
        if (ansList.size() != numCourses) {
            return new int[0];
        }
        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ans.length; i ++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }
}