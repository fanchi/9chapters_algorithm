/*
Given a list of numbers that may has duplicate numbers, return all possible subsets

 Notice
Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
Challenge 
Can you do it in both recursively and iteratively?

Tags 
Recursion
Related Problems 
Easy Sum of All Subsets 14 %
Easy Split String 20 %
Medium Subsets 26 %
*/
public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(ans, path, nums, 0, visited);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, int startInd, boolean[] visited) {
        if (startInd > nums.length) {
            return;
        }
        List<Integer> temp = new ArrayList<>(path);
        ans.add(temp);
        for (int i = startInd; i < nums.length; i ++) {
            if (i > startInd && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(ans, path, nums, i + 1, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}