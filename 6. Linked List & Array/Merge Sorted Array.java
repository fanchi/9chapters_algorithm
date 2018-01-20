/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Notice
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

Have you met this question in a real interview? Yes
Example
A = [1, 2, 3, empty, empty], B = [4, 5]

After merge, A will be filled as [1, 2, 3, 4, 5]

Tags 
Array Sorted Array Facebook
Related Problems 
Easy Space Replacement 18 %
Easy Merge Two Sorted Arrays 35 %
*/
// 使用游标i指向m + n - 1，也就是最大数值存放的地方，从后往前遍历A，B，谁大就放到i这里，同时递减i
public class Solution {
    /*
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int ind = m + n - 1, ind1 = m - 1, ind2 = n - 1;
        while (ind1 >= 0 && ind2 >= 0) {
            if (A[ind1] > B[ind2]) {
                A[ind] = A[ind1];
                ind1 --;
            }
            else {
                A[ind] = B[ind2];
                ind2 --;
            }
            ind --;
        }
        while (ind1 >= 0) {
            A[ind --] = A[ind1 --];
        }
        while (ind2 >= 0) {
            A[ind --] = B[ind2 --];
        }
    }
}