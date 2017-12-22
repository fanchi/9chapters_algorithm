/*
Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.

Have you met this question in a real interview? Yes
Example
Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].

Challenge 
O(logn + k) time complexity.

Tags 
Two Pointers Binary Search
Related Problems 
Medium K Closest Points 20 %
Easy Closest Number in Sorted Array 35 %
*/
public class Solution {
    /*
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        if (A[0] >= target) {
            int[] ans = Arrays.copyOfRange(A, 0, k);
            return ans;
        }
        else if (A[A.length - 1] <= target) {
            int[] ans = new int[k];
            for (int i = 0; i < k; i ++) {
                ans[i] = A[A.length -1 - i];
            }
            return ans;
        }
        else {
            int ind1 = lastSmallerOrEqual(A, target);
            int ind2 = firstBigger(A, target);
            int[] ans = new int[k];
            int ind = 0;
            while (ind1 >= 0 && ind2 <= A.length - 1 && ind < k) {
                int diff1 = target - A[ind1];
                int diff2 = A[ind2] - target;
                if (diff1 <= diff2) {
                    ans[ind] = A[ind1];
                    ind1 --;
                }
                else {
                    ans[ind] = A[ind2];
                    ind2 ++;
                }
                ind ++;
            }
            while (ind < k && ind1 >= 0) {
                ans[ind ++] = A[ind1 --];
            }
            while (ind < k && ind2 <= A.length - 1) {
                ans[ind ++] = A[ind2 ++];
            }
            return ans;
        }
    }
    private int lastSmallerOrEqual(int[] A, int target) {
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
    private int firstBigger(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > target) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        if (A[left] > target) {
            return left;
        }
        else {
            return right;
        }
    }
}