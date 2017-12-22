/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Have you met this question in a real interview? Yes
Example
For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.

Challenge 
O(logN) time

Tags 
LinkedIn Sorted Array Binary Search Array Uber Facebook
Related Problems 
Medium Search in Rotated Sorted Array II 40 %
Easy Search a 2D Matrix 28 %
*/
public class Solution {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int targetTemp = A[A.length - 1];
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= targetTemp) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        int pivot = A[left] < A[right] ? left : right;
        int ind1 = helper(A, 0, pivot, target);
        if (ind1 == -1) {
            int ind2 = helper(A, pivot, A.length - 1, target);
            return ind2 == -1 ? -1 : ind2;
        }
        else {
            return ind1;
        }
    }
    private int helper(int[] A, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            else if (A[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (A[start] == target) {
            return start;
        }
        else if (A[end] == target) {
            return end;
        }
        return -1;
    }
}