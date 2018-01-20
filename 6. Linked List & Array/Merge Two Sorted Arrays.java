/*
Merge two given sorted integer array A and B into a new sorted integer array.

Have you met this question in a real interview? Yes
Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]

Challenge 
How can you optimize your algorithm if one array is very large and the other is very small?

Tags 
Array Sorted Array
Related Problems 
Easy Intersection of Two Arrays II 23 %
Easy Intersection of Two Arrays 24 %
Easy Merge Two Sorted Lists 39 %
Medium Merge k Sorted Lists 29 %
Easy Merge Sorted Array 34 %
*/
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int[] array = new int[A.length + B.length];
        int index = 0, indA = 0, indB = 0;
        while(indA < A.length && indB < B.length){
            if(A[indA] < B[indB]){
                array[index] = A[indA];
                indA ++;
            }
            else{
                array[index] = B[indB];
                indB ++;
            }
                index ++;
        }//while
        if(indA < A.length){
            while(indA <= A.length - 1){
                array[index] = A[indA];
                indA ++;
                index ++;
            }
        }
        else{
            while(indB <= B.length - 1){
                array[index] = B[indB];
                indB ++;
                index ++;
            }
        }
        return array;
    }
}