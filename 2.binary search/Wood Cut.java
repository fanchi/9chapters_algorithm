/*
Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

 Notice
You couldn't cut wood into float length.

If you couldn't get >= k pieces, return 0.

Have you met this question in a real interview? Yes
Example
For L=[232, 124, 456], k=7, return 114.

Challenge 
O(n log Len), where Len is the longest length of the wood.

Tags 
Binary Search
*/
public class Solution {
    /*
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int longest = L[0];
        for (int i = 1; i < L.length; i ++) {
            longest = Math.max(longest, L[i]);
        }
        int left = 1, right = longest;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (getPiece(L, mid) >= k) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (getPiece(L, right) >= k) {
            return right;
        }
        else if (getPiece(L, left) >= k) {
            return left;
        }
        else {
            return 0;
        }
    }
    private int getPiece(int[] L, int len) {
        int ans = 0;
        for (int i = 0; i < L.length; i ++) {
            ans += L[i] / len;
        }
        return ans;
    }
};