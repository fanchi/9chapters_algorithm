/*
Given a list of numbers with duplicate number in it. Find all unique permutations.

Have you met this question in a real interview? Yes
Example
For numbers [1,2,2] the unique permutations are:

[
  [1,2,2],
  [2,1,2],
  [2,2,1]
]
Challenge 
Using recursion to do it is acceptable. If you can do it without recursion, that would be great!

Tags 
LinkedIn Recursion Depth First Search
Related Problems 
Medium Next Permutation II 34 %
Medium Permutation Sequence 28 %
Medium Next Permutation 25 %
Medium Permutations 28 %
*/
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(ans, path, nums, visited);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, List<Integer> path, int[] nums, boolean[] visited) {
        if (path.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(path);
            ans.add(temp);
        }
        for (int i = 0; i < nums.length; i ++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
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


