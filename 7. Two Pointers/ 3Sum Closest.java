/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.

 Notice
You may assume that each input would have exactly one solution.

Have you met this question in a real interview? Yes
Example
For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Challenge 
O(n^2) time, O(1) extra space

Tags 
Sort Array Two Pointers
Related Problems 
Medium Two Sum - Closest to target 43 %
Medium 3Sum 21 %
Easy Two Sum 28 %
*/
public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Arrays.sort(numbers);
        int diff = Integer.MAX_VALUE, ans = 0;
        boolean isPos = false;
        for (int i = 0; i <= numbers.length - 3; i ++) {
            int left = i + 1, right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == target) {
                    return sum;
                }
                else if (sum < target) {
                    left ++;
                    if (target - sum < diff) {
                        diff = target - sum;
                        isPos = false;
                    }
            }
            else {
                right --;
                if (sum - target < diff) {
                    diff = sum - target;
                    isPos = true;
                }
            }
            }
        }
        if (isPos) {
            return target + diff;
        }
        else {
            return target - diff;
        }
    }
}