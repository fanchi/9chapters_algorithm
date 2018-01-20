/*
Given an integer arrays, find a contiguous subarray which has the largest sum and length should be between k1 and k2 (include k1 and k2).
Return the largest sum, return 0 if there are fewer than k1 elements in the array.

 Notice
Ensure that the result is an integer type.

Have you met this question in a real interview? Yes
Example
Given the array [-2,2,-3,4,-1,2,1,-5,3] and k1 = 2, k2 = 4, the contiguous subarray [4,-1,2,1] has the largest sum = 6.

Tags 
Array Subarray
Related Problems 
Super Maximum Subarray VI 21 %
Medium Maximum Subarray IV 35 %
Medium Maximum Average Subarray 18 %
Hard Maximum Subarray III 25 %
Medium Maximum Subarray II 26 %
Easy Maximum Subarray 38 %
*/
// 暂时放弃. copied from solution
/**
* 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
* - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
* - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
* - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
* - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
*/ 

public class Solution {
    /**
     * @param nums an array of integers
     * @param k1 an integer
     * @param k2 an integer
     * @return the largest sum
     */
    public int maxSubarray5(int[] nums, int k1, int k2) {
        // Write your code here
        int n = nums.length;
        if (n < k1)
            return 0;

        int result = Integer.MIN_VALUE;

        int[] sum = new int[n + 1];
        sum[0] = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i <= n; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];

            if (!queue.isEmpty() && queue.getFirst() < i - k2) {
                queue.removeFirst();
            }
            if (i >= k1) {
                while (!queue.isEmpty() && sum[queue.getLast()] > sum[i - k1]) {
                    queue.removeLast();
                }
                queue.add(i - k1);
            }

            // [i - k2, i - k1]
            if (!queue.isEmpty() && sum[i] - sum[queue.getFirst()] > result) {
                result = Math.max(result, sum[i] - sum[queue.getFirst()]);
            }


        }
        return result;
    }
}