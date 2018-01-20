/*
Given an integer array, find the top k largest numbers in it.

Have you met this question in a real interview? Yes
Example
Given [3,10,1000,-99,4,100] and k = 3.
Return [1000, 100, 10].

Tags 
Heap Priority Queue
Related Problems 
Medium High Five 31 %
Hard Top K Frequent Words II 17 %
Medium Top k Largest Numbers II 29 %
Medium Top K Frequent Words 19 %
*/

/*
new Comparator(){
public int compare(Integer val1, Integer val2){
return val2 - val1; // max -> min, descending order
// return val1 - val2; // min -> max, ascending order
}
}
*/

public class Solution {
    /*
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i: nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] ans = new int[minHeap.size()];
        int ind = ans.length - 1;
        while (!minHeap.isEmpty()) {
            ans[ind --] = minHeap.poll();
        }
        return ans;
    }
}