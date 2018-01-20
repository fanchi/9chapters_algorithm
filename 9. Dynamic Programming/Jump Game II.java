/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Have you met this question in a real interview? Yes
Example
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Tags 
Greedy Array
Related Problems 
Medium Jump Game
*/
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int[] dp = new int[A.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        if(A.length < 2){
            return 1;
        }
        for(int i = 1; i < dp.length; i ++){
            for(int j = 0; j < i; j ++){
                if(dp[j] != Integer.MAX_VALUE && A[j] >= i - j){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        // if(dp[dp.length - 1] == Integer.MAX_VALUE){
        //     return -1;
        // }
        return dp[dp.length - 1];
    }
}
