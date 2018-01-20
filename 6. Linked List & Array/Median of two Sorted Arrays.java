/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.

Have you met this question in a real interview? Yes
Example
Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.

Given A=[1,2,3] and B=[4,5], the median is 3.

Challenge 
The overall run time complexity should be O(log (m+n)).

Tags 
Array Zenefits Divide and Conquer Sorted Array Uber Google
Related Problems 
Hard Data Stream Median 29 %
Easy Median 24 %
*/
/*
看小视频 in two pointer section: quick select
找从小到大第(m + n)/2个数。
meidan = (第五小的数 + 第六小的数)/2
k = 5
k/2 = 5/2 = 2
要在两个里面找第K小的数，分别在数组A和数组B里找第K/2小的数
O(log(K))
在log(k)时间内找到从下到大第K个数
*/
public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    //下标是不可能搞对的
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (double)(helper(A, 0, B, 0, len / 2 - 1) + helper(A, 0, B, 0, len / 2)) / 2.0;
        }
        else {
            return (double)helper(A, 0, B, 0, len / 2);
        }
    }
    private int helper(int[] A, int startA, int[] B, int startB, int k) {
        System.out.println(k);
        if (startA > A.length - 1) {
            return helper(A, startA, B, startB, k - A.length);
        }
        if (startB > B.length - 1) {
            return helper(A, startA, B, startB, k - B.length);
        }
        if (k == 0) {
            return Math.min(A[startA], B[startB]);
        }
        int indA = startA + k / 2 < A.length ? A[startA + k / 2] : Integer.MAX_VALUE;
        int indB = startB + k / 2 < B.length ? B[startB + k / 2] : Integer.MAX_VALUE;
        if (indA < indB) {
            return helper(A, indA + k / 2, B, indB, k - k / 2);
        }
        else {
            return helper(A, indA, B, indB + k / 2, k - k / 2);
        }
    }
}