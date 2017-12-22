/*
Given a sorted array of n integers, find the starting and ending position of a given target value.

If the target is not found in the array, return [-1, -1].

Have you met this question in a real interview? Yes
Example
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

Challenge 
O(log n) time.

Tags 
Sorted Array Binary Search Array
Related Problems 
Medium Range Sum Query 2D - Immutable 23 %
Easy Total Occurrence of Target
*/
public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[2];
        if(A == null || A.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int index = findFirstEqual(A, 0, A.length - 1, target);
        if(index == -1){
            result[0] = -1;
            result[1] = -1;
        }
        else{
            result[0] = index;
            int index2 = findFirstGreater(A, index, A.length - 1, target);
            if(index2 == -1){
                result[1] = A.length - 1;
            }
            else{
                result[1] = index2 - 1;
            }
        }
        return result;
    }
    private int findFirstEqual(int[] A, int start, int end, int target){
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] >= target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(A[start] == target){
            return start;
        }
        if(A[end] == target){
            return end;
        }
        return -1;
    }
    private int findFirstGreater(int[] A, int start, int end, int target){
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] > target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(A[start] > target){
            return start;
        }
        if(A[end] > target){
            return end;
        }
        return -1;
    }
}
