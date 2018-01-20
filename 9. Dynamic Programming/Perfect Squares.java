/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Have you met this question in a real interview? Yes
Example
Given n = 12, return 3 because 12 = 4 + 4 + 4
Given n = 13, return 2 because 13 = 4 + 9

Tags 
Dynamic Programming Mathematics
Related Problems 
Easy Check Sum of Square Numbers 15 %
Medium Ugly Number II 24 %
*/
public class Solution {
    /*
     * @param n: a positive integer
     * @return: An integer
     */
    public int numSquares(int n) {
        // write your code here
        int[] dp = new int[n + 1];
        dp[0] = 0;
        ArrayList<Integer> perfect = new ArrayList<>();
        for (int i = 1; i <= n; i ++) {
            int root = (int)Math.sqrt(i);
            if (root * root == i) {
                dp[i] = 1;
                perfect.add(i);
            }
            else {
                int min = i;
                for (int j = perfect.size() - 1; j >= 0; j --) {
                    min = Math.min(min, 1 + dp[i - perfect.get(j)]);
                }
                dp[i] = min;
            }
        }
        // for (int i = 0; i <=n; i ++) {
        //     System.out.print(dp[i] + " ");
        // }
        // System.out.println();
        return dp[n];
    }
}