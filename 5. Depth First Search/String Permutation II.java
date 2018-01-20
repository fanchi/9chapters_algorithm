/*
Given a string, find all permutations of it without duplicates.

Have you met this question in a real interview? Yes
Example
Given "abb", return ["abb", "bab", "bba"].

Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].

Tags 
Permutation Recursion String
Related Problems 
Easy String Permutation 29 %
*/
public class Solution {
    /*
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> ans = new ArrayList<>();
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = new String(chars);
        String path = "";
        boolean[] visited = new boolean[str.length()];
        dfs(ans, path, str, visited);
        return ans;
    }
    private void dfs(List<String> ans, String path, String str, boolean[] visited) {
        if (path.length() == str.length()) {
            String temp = new String(path);
            ans.add(temp);
        }
        for (int i = 0; i < str.length(); i ++) {
            if (visited[i] || i > 0 && str.charAt(i) == str.charAt(i - 1) && !visited[i - 1]) {
                continue;
            }
            path = path + String.valueOf(str.charAt(i));
            visited[i] = true;
            dfs(ans, path, str, visited);
            path = path.substring(0, path.length() - 1);
            visited[i] = false;
        }
    }
}