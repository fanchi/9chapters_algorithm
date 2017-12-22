/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Have you met this question in a real interview? Yes
Example
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.

Challenge 
O(log(n) + log(m)) time

Tags 
Binary Search Matrix Yahoo
Related Problems 
Medium Search in Rotated Sorted Array 30 %
Medium Search a 2D Matrix II 36 %
*/
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / n][mid % n] == target) {
                return true;
            }
            else if (matrix[mid / n][mid % n] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target) {
            return true;
        }
        return false;
    }
}
