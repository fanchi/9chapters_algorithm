/*
Given a list of numbers, return all possible permutations.

 Notice
You can assume that there is no duplicate numbers in the list.

Have you met this question in a real interview? Yes
Example
For nums = [1,2,3], the permutations are:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
Challenge 
Do it without recursion.

Tags 
LinkedIn Recursion
Related Problems 
Medium Print Numbers by Recursion 26 %
Medium Permutation Sequence 28 %
Medium Permutations II 26 %
*/
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(ans, path, nums, visited);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(path);
            ans.add(temp);
        }
        for (int i = 0; i < nums.length; i ++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(ans, path, nums, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
