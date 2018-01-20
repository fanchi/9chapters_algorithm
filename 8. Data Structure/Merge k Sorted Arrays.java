/*
Given k sorted integer arrays, merge them into one sorted array.

Have you met this question in a real interview? Yes
Example
Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

Challenge 
Do it in O(N log k).

N is the total number of integers.
k is the number of arrays.
Tags 
Heap Priority Queue
Related Problems 
Medium Merge k Sorted Lists 29 %
*/
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> ans = new ArrayList<>();
        if (arrays == null || arrays.length == 0) {
            return ans;
        }
        PriorityQueue<MyType> pq = new PriorityQueue<>(arrays.length, new MyComp());
        for (int i = 0; i < arrays.length; i ++) {
            if (arrays[i].length > 0) {
                MyType myType = new MyType(arrays[i][0], i, 0);
                pq.offer(myType);
            }
        }
        while (!pq.isEmpty()) {
            MyType myType = pq.poll();
            ans.add(myType.val);
            int indI = myType.indI;
            int indJ = myType.indJ;
            if (indJ + 1< arrays[indI].length) {
                MyType newType = new MyType(arrays[indI][indJ + 1], indI, indJ + 1);
                pq.offer(newType);
            }
        }
        return ans;
    }
    private class MyType {
        int val;
        int indI;
        int indJ;
        private MyType (int val, int i, int j) {
            this.val = val;
            this.indI = i;
            this.indJ = j;
        }
    }
    class MyComp implements Comparator<MyType> {
        public int compare(MyType m1, MyType m2) {
            return m1.val - m2.val;
        }
    }
}