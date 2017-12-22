/*
Given a set of distinct integers, return all possible subsets.

 Notice
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Challenge 
Can you do it in both recursively and iteratively?

Tags 
Recursion Uber Facebook
Related Problems 
Easy Sum of All Subsets 13 %
Easy Split String 19 %
Medium Restore IP Addresses 23 %
Medium Subsets II 26 %
*/
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        if(nums == null || nums.length == 0){
            ans.add(temp);
            return ans;
        }
        Arrays.sort(nums);
        dfs(ans, temp, nums, 0);
        return ans;
    }
    private void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> temp, int[] nums, int startInd){
        ArrayList<Integer> path = new ArrayList<>(temp);
        ans.add(path);
        for(int i = startInd; i < nums.length; i ++){
            temp.add(nums[i]);
            dfs(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}