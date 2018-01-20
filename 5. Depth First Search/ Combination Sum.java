/*
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

 Notice
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Have you met this question in a real interview? Yes
Example
Given candidate set [2,3,6,7] and target 7, a solution set is:

[7]
[2, 2, 3]
Tags 
Array Backtracking
Related Problems 
Medium Coin Change II 28 %
Hard Compute 24 Game 33 %
Hard Add Operators 28 %
Medium Combination Sum II 30 %
*/
public class Solution {
    /*
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, path, candidates, target, 0, -1);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] candidates, int target, int startInd, int prev) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(path);
            ans.add(temp);
            return;
        }
        for (int i = startInd; i < candidates.length; i ++) {
            if (i > startInd && candidates[i] == candidates[i - 1] && candidates[i - 1] == prev || candidates[i] > target) {
                continue;
            }
            path.add(candidates[i]);
            dfs(ans, path, candidates, target - candidates[i], i, candidates[i]);
            path.remove(path.size() - 1);
        }
    }
    
}