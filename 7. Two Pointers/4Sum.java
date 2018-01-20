/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.

 Notice
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

Have you met this question in a real interview? Yes
Example
Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)
(-2, -1, 1, 2)
(-2, 0, 0, 2)
Tags 
Sort Array Two Pointers Hash Table
Related Problems 
Medium 3Sum 21 %
Easy Two Sum 28 %
*/

/*
O(n^2)解法：best O(n^2), worst O(n^3)
for(a....)
for(b....)
hash.add(a + b), 不只是和，要加进这个组合

for(c....)
for(d...)
hash.contains((target - c -d))
*/
public class Solution {
    /*
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return ans;
        }
        Arrays.sort(numbers);
        for (int i = 0; i <= numbers.length - 4; i ++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= numbers.length - 3; j ++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int left = j + 1, right = numbers.length - 1;
                while (left < right) {
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if (sum < target) {
                        left ++;
                    }
                    else if (sum > target) {
                        right --;
                    }
                    else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(numbers[i]);
                        temp.add(numbers[j]);
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
                }// while
            }// for j
        }// for i
        return ans;
    }
}