/*
Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 10^4. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

Have you met this question in a real interview? Yes
Example
Given org = [1,2,3], seqs = [[1,2],[1,3]]
Return false
Explanation:
[1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.

Given org = [1,2,3], seqs = [[1,2]]
Return false
Explanation:
The reconstructed sequence can only be [1,2].

Given org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
Return true
Explanation:
The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].

Given org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
Return true
Tags 
Airbnb Topological Sort Breadth First Search Google
Related Problems 
Medium Course Schedule II 21 %
Medium Topological Sorting 30 %
*/
public class Solution {
    /*
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        if (org == null || seqs == null) {
            return false;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        int count = 0;
        for (int i = 0; i < seqs.length; i ++) {
            if (seqs[i].length > org.length) {
                return false;
            }
            count += seqs[i].length;
            for (int j = 0; j < seqs[i].length; j ++) {
                int prev = seqs[i][j];
                if (prev < 1 || prev > org.length) {
                    return false;
                }
                if (!graph.containsKey(prev)) {
                    Set<Integer> set = new HashSet<>();
                    graph.put(prev, set);
                }
                if (j + 1 >= seqs[i].length) {
                    continue;
                }
                int next = seqs[i][j + 1];
                if (next < 1 || next > org.length) {
                    return false;
                }
                graph.get(prev).add(next);
            }
        }
        if (count < org.length) {
            return false;
        }
        for (Integer prev: graph.keySet()) {
            Set<Integer> nexts = graph.get(prev);
            for (int next: nexts) {
                if (inDegree.containsKey(next)) {
                    inDegree.put(next, inDegree.get(next) + 1);
                }
                else {
                    inDegree.put(next, 1);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int val: org) {
            if (!inDegree.containsKey(val)) {
                queue.offer(val);
            }
        }
        int total = 0;
        while (queue.size() == 1) {
            int val = queue.poll();
            total ++;
            Set<Integer> nexts = graph.get(val);
            if (nexts == null) {
                continue;
            }
            for (int next: nexts) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        return total == org.length;
    }
}