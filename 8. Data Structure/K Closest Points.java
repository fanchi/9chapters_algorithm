/*
Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

Have you met this question in a real interview? Yes
Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]

Tags 
LinkedIn Amazon Heap
Related Problems 
Medium K Closest Numbers In Sorted Array 23 %
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        if (points == null || points.length == 0) {
            return new Point[0];
        }
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k, new MyComparator(origin));
        for (Point p: points) {
            if (pq.size() < k) {
                pq.offer(p);
            }
            else {
                pq.offer(p);
                pq.poll();
            }
        }
        Point[] ans = new Point[pq.size()];
        int ind = ans.length - 1;
        while (!pq.isEmpty()) {
            ans[ind --] = pq.poll();
        }
        return ans;
    }
    // 应该是max heap，大的出来
    // 注意写法
    class MyComparator implements Comparator<Point> {
        Point p;
        public MyComparator(Point point) {
            this.p = point;
        }
        public int compare(Point p1, Point p2) {
            int diff1 = (p1.x - p.x) * (p1.x - p.x) + (p1.y - p.y) * (p1.y - p.y);
            int diff2 = (p2.x - p.x) * (p2.x - p.x) + (p2.y - p.y) * (p2.y - p.y);
            if (diff1 == diff2) {
                if (p1.x == p2.x) {
                    return p2.y - p1.y;
                }
                else {
                    return p2.x - p1.x;
                }
            }
            else {
                return diff2 - diff1;
            }
        }
    }
}