/*
Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.

Have you met this question in a real interview? Yes
Example
Given [1, 3, 3, 4, 5] and target = 3, return 2.

Given [2, 2, 3, 4, 6] and target = 4, return 1.

Given [1, 2, 3, 4, 5] and target = 6, return 0.

Challenge 
Time complexity in O(logn)

Tags 
Binary Search
Related Problems 
Medium Search for a Range 25 %
*/
//______先在整个数组中二分找first，再在以first为首的sub array中二分找第一个比target大的
public class Solution{
    public int totalOccurrence(int[] A, int target) {
        if(A == null || A.length == 0){
            return 0;
        }
        //find first
        int index = findFirstEqual(A, 0, A.length - 1, target);
        if(index == -1){
            return 0;
        }
        else{
            int end = findFirstLarger(A, index, A.length - 1, target);
            if(end == -1){
                return A.length - index;
            }
            return end - index;
        }
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
    private int findFirstLarger(int[] A, int start, int end, int target){
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
        return - 1;
    }
}
//____先在整个数组找二分找到first，再在以first为首的sub array 中二分找last，还是TLE
// public class Solution{
//     public int totalOccurrence(int[] A, int target) {
//         if(A == null || A.length == 0){
//             return 0;
//         }
//         //find first
//         int index = findFirst(A, 0, A.length - 1, target);
//         if(index == -1){
//             return 0;
//         }
//         else{
//             int end = findLast(A, index, A.length - 1, target);
//             return end - index + 1;
//         }
//     }
//     private int findFirst(int[] A, int start, int end, int target){
//         while(start + 1 < end){
//             int mid = start + (end - start)/2;
//             if(A[mid] >= target){
//                 end = mid;
//             }
//             else{
//                 start = mid;
//             }
//         }
//         if(A[start] == target){
//             return start;
//         }
//         if(A[end] == target){
//             return end;
//         }
//         return -1;
//     }
//     private int findLast(int[] A, int start, int end, int target){
//         while(start + 1 < end){
//             int mid = start + (end - start)/2;
//             if(A[mid] <= target){
//                 start = mid;
//             }
//             else{
//                 end = mid;
//             }
//         }
//         if(A[end] == target){
//             return end;
//         }
//         if(A[start] == target){
//             return start;
//         }
//         return - 1;
//     }
// }
//_________在整个数组上做两次二分，一次找first，一次找last, TLE
// public class Solution {
//     /**
//      * @param A an integer array sorted in ascending order
//      * @param target an integer
//      * @return an integer
//      */
//     public int totalOccurrence(int[] A, int target) {
//         // Write your code here
//         if(A == null || A.length == 0){
//             return 0;
//         }
//         int first = findFirst(A, target);
//         int last = findLast(A, target);
//         if(first == - 1){
//             return 0;
//         }
//         return last - first + 1;
//     }
//     private int findFirst(int[] A, int target){
//         int start = 0, end = A.length - 1;
//         while(start + 1 < end){
//             int mid = start + (end - start)/2;
//             if(A[mid] >= target){
//                 end = mid;
//             }
//             else{
//                 start = mid;
//             }
//         }
//         if(A[start] == target){
//             return start;
//         }
//         if(A[end] == target){
//             return end;
//         }
//         return -1;
//     }
//     private int findLast(int[] A, int target){
//         int start = 0, end = A.length - 1;
//         while(start + 1 < end){
//             int mid = start + (end - start)/2;
//             if(A[mid] <= target){
//                 start = mid;
//             }
//             else{
//                 end = mid;
//             }
//         }
//         if(A[end] == target){
//             return end;
//     }
//     if(A[start] == target){
//         return start;
//     }
//     return -1;
//     }
// }