/*
Ugly number is a number that only have factors 2, 3 and 5.

Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

 Notice
Note that 1 is typically treated as an ugly number.

Have you met this question in a real interview? Yes
Example
If n=9, return 10.

Challenge 
O(n log n) or O(n) time.

Tags 
LintCode Copyright Priority Queue
Related Problems 
Medium Super Ugly Number 28 %
Medium Perfect Squares 32 %
Easy Happy Number 32 %
Medium Merge k Sorted Lists 29 %
*/
public class Solution {
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    // 用HashSet去重
    public int nthUglyNumber(int n) {
        // write your code here
        if (n < 1) {
            return 0;
        }
        else {
            Set<Long> set = new HashSet<>();
            int ind = 0;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            pq.offer((long)1);
            set.add((long)1);
            long prev = -1;
            while (true) {
                prev = pq.poll();
                ind ++;
                if (ind == n) {
                    break;
                }
                if (!set.contains(prev * 2)) {
                    pq.offer(prev * 2);
                    set.add(prev * 2);
                }
                if (!set.contains(prev * 3)) {
                    pq.offer(prev * 3);
                    set.add(prev * 3);
                }
                if (!set.contains(prev * 5)) {
                    pq.offer(prev * 5);
                    set.add(prev * 5);
                }
            }
            return (int)prev;
        }
    }
}