/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Notice
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Have you met this question in a real interview? Yes
Example
Given candidate set [10,1,6,7,2,1,5] and target 8,

A solution set is:

[
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]
Tags 
Array Backtracking Depth First Search
Related Problems 
Medium Coin Change II 28 %
Hard Add Operators 28 %
Medium Combination Sum 28 %
*/
public class Solution {
    /*
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (num == null || num.length == 0) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        Arrays.sort(num);
        dfs(ans, path, num, target, 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] num, int target, int startInd) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(path);
            ans.add(temp);
        }
        int prev = -1;
        for (int i = startInd; i < num.length; i ++) {
            if (num[i] > target) {
                break;
            }
            if (i > startInd && num[i] == num[i - 1] && prev != -1) {
                continue;
            }
            path.add(num[i]);
            dfs(ans, path, num, target - num[i], i + 1);
            path.remove(path.size() - 1);
            prev = num[i];
        }
    }
}