/*
Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Have you met this question in a real interview? Yes
Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".

Tags 
Dynamic Programming String
Related Problems 
Medium Word Break III 33 %
Easy Split String 20 %
Hard Word Break II 20 %
*/
/*
dfs stackoverflow
should use dp
*/
public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null || dict == null) {
            return false;
        }
        if (s.length() == 0) {
            return dict.size() == 0;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int longest = 0;
        for (String str: dict) {
            longest = Math.max(longest, str.length());
        }
        for (int i = 1; i < dp.length; i ++) {
            dp[i] = false;
            for (int j = i - 1; j >= 0 && i - j <= longest; j --) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}