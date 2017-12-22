/*
Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.

Return -1 if there is no element in the array.

 Notice
There can be duplicate elements in the array, and we can return any of the indices with same value.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 3] and target = 2, return 1.

Given [1, 4, 6] and target = 3, return 1.

Given [1, 4, 6] and target = 5, return 1 or 2.

Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.

Challenge 
O(logn) time complexity.

Tags 
Binary Search
Related Problems 
Medium K Closest Numbers In Sorted Array 23 %
Easy Last Position of Target 36 %
Easy Classical Binary Search 37 %
Easy First Position of Target 33 %
*/
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int ind1 = lastSmaller(A, target);
        int ind2 = firstBigger(A, ind1, A.length - 1, target);
        int diff1 = target - A[ind1], diff2 = A[ind2] - target;
        return diff1 < diff2 ? ind1 : ind2;
    }
    private int lastSmaller(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (A[right] <= target) {
            return right;
        }
        else {
            return left;
        }
    }
    private int firstBigger(int[] A, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if (A[start] >= target) {
            return start;
        }
        else {
            return end;
        }
    }
}