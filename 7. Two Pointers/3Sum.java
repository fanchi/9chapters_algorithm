/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Notice
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

Have you met this question in a real interview? Yes
Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)
Tags 
Sort Array Two Pointers Facebook
Related Problems 
Medium Triangle Count 32 %
Medium 3Sum Closest 31 %
Medium 4Sum 22 %
Easy Two Sum 28 %
*/
public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return ans;
        }
        Arrays.sort(numbers);
        for (int i = 0; i <= numbers.length - 3; i ++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int target = -1 * numbers[i];
            int left = i + 1, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(numbers[i]);
                    temp.add(numbers[left]);
                    temp.add(numbers[right]);
                    ans.add(temp);
                    left ++;
                    right --;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left ++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right --;
                    }
                }
                else if (sum < target) {
                    left ++;
                }
                else {
                    right --;
                }
            }
        }
        return ans;
    }
}