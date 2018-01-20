/*
Given a string s, cut s into some substrings such that every substring is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab",

Return 1 since the palindrome partitioning ["aa", "b"] could be produced using 1 cut.

Tags 
Dynamic Programming
Related Problems 
Medium Wiggle Sort II 25 %
Medium Palindrome Partitioning 28 %
Medium Longest Palindromic Substring 28 %
*/
public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    // 不可能想出来，不可能做对
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        boolean[][] palins = getPalin(s);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i ++) {
            dp[i] = i;
            for (int j = 0; j < i; j ++) {
                if (palins[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1] - 1;
    }
    private boolean[][] getPalin(String s) {
        int n = s.length();
        boolean[][] ans = new boolean[n][n];
        for (int i = 0; i < n; i ++) {
            ans[i][i] = true;
            if (i > 0) {
                ans[i][i - 1] = true;
            }
        }
        for (int len = 2; len <= n; len ++) {
            for (int i = 0; i <= n - len; i ++) {
                int j = i + len - 1;
                ans[i][j] = ans[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        return ans;
    }
};