/*
There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.

Have you met this question in a real interview? Yes
Example
Given results = [[1,91],[1,92],[2,93],[2,99],[2,98],[2,97],[1,60],[1,58],[2,100],[1,61]]

Return 
Tags 
Amazon Heap
Related Problems 
Medium Top k Largest Numbers 35 %
*/
/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        Map<Integer, Double> ans = new HashMap<>();
        if (results == null || results.length == 0) {
            return ans;
        }
        for (int i = 0; i < results.length; i ++) {
            int id = results[i].id;
            int score = results[i].score;
            if (!map.containsKey(id)) {
                PriorityQueue<Integer> minHeap = new PriorityQueue<>();
                minHeap.offer(score);
                map.put(id, minHeap);
            }
            else {
                if (map.get(id).size() < 5) {
                    map.get(id).offer(score);
                }
                else {
                    map.get(id).offer(score);
                    map.get(id).poll();
                }
            }
        }
        for (int key: map.keySet()) {
            PriorityQueue<Integer> minHeap = map.get(key);
            double sum = 0, size = minHeap.size();
            while (!minHeap.isEmpty()) {
                sum += minHeap.poll();
            }
            ans.put(key, sum/(double)size);
        }
        return ans;
    }
}