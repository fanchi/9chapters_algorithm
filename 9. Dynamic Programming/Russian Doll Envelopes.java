/*
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

What is the maximum number of envelopes can you Russian doll? (put one inside other)

Have you met this question in a real interview? Yes
Example
Given envelopes = [[5,4],[6,4],[6,7],[2,3]], 
the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

Tags 
Dynamic Programming Binary Search Facebook
Related Problems 
Medium Longest Increasing Subsequence 30 %
*/
// binary search 法通不过，不知道为啥。dp O(n^2) TLE
//抄的答案，因为自己怎么都做不对
public class Solution {
    /**
     * @param envelopes a number of envelopes with widths and heights
     * @return the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // Write your code here
        if(envelopes == null || envelopes.length == 0 
            || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            } 
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
                if(index < 0)
                    index = -index - 1;
            dp[index] = envelope[1];
            if (index == len)
                len++;
        }
        return len;
    }
}

//_____bianry search, based on Longest Increasing Subsequence
// Longest Increasing Subsequence does not need sort, because it finds subsequence in original array
// this problem needs sort first
// 但是还是不对，不知道为啥。
// public class Solution{
//     public int maxEnvelopes(int[][] envelopes){
//         if(envelopes == null || envelopes.length == 0){
//             return 0;
//         }
//         Arrays.sort(envelopes, new Comparator<int[]>(){
//             public int compare(int[] array1, int[] array2){
//                 if(array1[0] == array2[0]){
//                     return array1[1] - array2[1];
//                 }
//                 else{
//                     return array1[0] - array2[0];
//                 }
//             }
//         });
//         int[][] temp = new int[envelopes.length][envelopes[0].length];
//         temp[0][0] = envelopes[0][0];
//         temp[0][1] = envelopes[0][1];
//         int cur = 0;
//         for(int i = 1; i < envelopes.length; i ++){
//             if(myCompare(envelopes[i], temp[0]) < 0){
//                 temp[0][0] = envelopes[i][0];
//                 temp[0][1] = envelopes[i][1];
//             }
//             else if(myCompare(envelopes[i], temp[cur]) > 0){
//                 cur ++;
//                 temp[cur][0] = envelopes[i][0];
//                 temp[cur][1] = envelopes[i][1];
//             }
//             else{
//                 int index = findFirst(temp, 0, cur, envelopes[i]);
//                 temp[index][0] = envelopes[i][0];
//                 temp[index][1] = envelopes[i][1];
//             }
//         }
//         return cur + 1;
//     }
//     private int myCompare(int[] array1, int[] array2){
//         // be careful of equal
//         if(array1[0] < array2[0] && array1[1] < array2[1]){
//             return -1;
//         }
//         if(array1[0] <= array2[0] && array1[1] >= array2[1] || array1[0] >= array2[0] && array1[1] <= array2[1]){
//             return 0;
//         }
//         else{
//             return 1;
//         }
//     }
//     // private int myCompare(int[] array1, int[] array2){
//     //     if(array1[0] == array2[0]){
//     //         return array1[1] - array2[1];
//     //     }
//     //     else{
//     //         return array1[0] - array2[0];
//     //     }
//     // }
//     private int findFirst(int[][] array, int start, int end, int[] target){
//         while(start + 1 < end){
//         int mid = start + (end - start)/2;
//         if(myCompare(array[mid], target) >= 0){
//             end = mid;
//         }
//         else{
//             start = mid;
//         }
//     }
//     if(myCompare(array[start], target) >= 0){
//         return start;
//     }
//     return end;
//     }
// }

//________dp, similar to Longest Increasing Subsequence
// https://www.lintcode.com/en/problem/longest-increasing-subsequence/
// Time Limit exceeded
// public class Solution {
//     /**
//      * @param envelopes a number of envelopes with widths and heights
//      * @return the maximum number of envelopes
//      */
//     public int maxEnvelopes(int[][] envelopes) {
//         // Write your code here
//         if(envelopes == null || envelopes.length == 0){
//             return 0;
//         }
//         Arrays.sort(envelopes, new Comparator<int[]>(){
//             public int compare(int[] array1, int[] array2){
//                 if(array1[0] == array2[0]){
//                     return array1[1] - array2[1];
//                 }
//                 else{
//                     return array1[0] - array2[0];
//                 }
//             }
//         });
//         int[] dp = new int[envelopes.length];
//         dp[0] = 1;
//         int longest = 1;
//         for(int i = 1; i < dp.length; i ++){
//             dp[i] = 1;
//             for(int j = 0; j < i; j ++){
//                 if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             longest = Math.max(longest, dp[i]);
//         }
//         return longest;
//     }
// }