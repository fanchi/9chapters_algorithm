/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Have you met this question in a real interview? Yes
Example
Given s = "aab", return:

[
  ["aa","b"],
  ["a","a","b"]
]
Tags 
Backtracking Depth First Search
Related Problems 
Medium Palindrome Partitioning II
*/
public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        List<String> path = new ArrayList<>();
        dfs(ans, path, s, 0);
        return ans;
    }
    private void dfs(List<List<String>> ans, List<String> path, String s, int startInd) {
        if (startInd >= s.length()) {
            List<String> temp = new ArrayList<>(path);
            ans.add(temp);
            return;
        }
        for (int i = startInd; i < s.length(); i ++) {
            String str = s.substring(startInd, i + 1);
            if (!isPalin(str)) {
                continue;
            }
            path.add(str);
            dfs(ans, path, s, i + 1);
            path.remove(path.size() - 1);
        }
    }
    private boolean isPalin(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}