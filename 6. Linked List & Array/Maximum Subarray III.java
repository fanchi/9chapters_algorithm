/*
Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

 Notice
The subarray should contain at least one number

Have you met this question in a real interview? Yes
Example
Given [-1,4,-2,3,-2,3], k=2, return 8

Tags 
Dynamic Programming Array Subarray LintCode Copyright
Related Problems 
Hard Maximum Subarray V 29 %
Medium Maximum Subarray IV 35 %
Medium Best Time to Buy and Sell Stock III 27 %
Medium Best Time to Buy and Sell Stock II 49 %
Medium Best Time to Buy and Sell Stock 41 %
Medium Maximum Subarray Difference 24 %
Hard Maximum Subarray III 25 %
Medium Maximum Subarray II 26 %
Easy Maximum Subarray 38 %
*/
//绝对想不出来是这么做的，抄的答案
/*
local[i][k]表示前i个元素取k个子数组并且必须包含第i个元素的最大和。
global[i][k]表示前i个元素取k个子数组不一定包含第i个元素的最大和。
local[i][k]的状态函数：

max(global[i-1][k-1], local[i-1][k]) + nums[i-1]

有两种情况，第一种是第i个元素自己组成一个子数组，则要在前i－1个元素中找k－1个子数组，第二种情况是第i个元素属于前一个元素的子数组，因此要在i－1个元素中找k个子数组（并且必须包含第i－1个元素，这样第i个元素才能合并到最后一个子数组中），取两种情况里面大的那个。
global[i][k]的状态函数：

max(global[i-1][k]，local[i][k])

有两种情况，第一种是不包含第i个元素，所以要在前i－1个元素中找k个子数组，第二种情况为包含第i个元素，在i个元素中找k个子数组且必须包含第i个元素，取两种情况里面大的那个。+


*/
public class Solution{
    public int maxSubArray(int[] nums, int k){
        if(nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return 0;
        }
        int[][] localMax = new int[nums.length + 1][k + 1];
        int[][] globMax = new int[nums.length + 1][k + 1];
        for(int len = 1; len <= k; len ++){
            localMax[len - 1][len] = Integer.MIN_VALUE;
            // i 的选取屌炸天，绝对想不出来
            for(int i = len; i <= nums.length; i ++){
                localMax[i][len] = Math.max(globMax[i - 1][len - 1], localMax[i - 1][len]) + nums[i - 1];
                if(i == len){
                    globMax[i][len] = localMax[i][len];
                }
                else{
                    globMax[i][len] = Math.max(globMax[i - 1][len], localMax[i][len]);
                }
            }
        }
        return globMax[nums.length][k];
    }
}
// wrong
// public class Solution {
//     /**
//      * @param nums: A list of integers
//      * @param k: An integer denote to find k non-overlapping subarrays
//      * @return: An integer denote the sum of max k non-overlapping subarrays
//      */
//     class Record{
//         int start;
//         int end;
//         int maxVal;
//         public Record(int start, int end, int maxVal){
//             this.start = start;
//             this.end = end;
//             this.maxVal = maxVal;
//         }
//     }
//     public int maxSubArray(int[] nums, int k) {
//         // write your code here
//         if(nums == null || nums.length == 0 || k < 1 || k > nums.length){
//             return 0;
//         }
//         ArrayList<Record> left = new ArrayList<>();
//         ArrayList<Record> right = new ArrayList<>();
        
//         left.add(new Record(0, 0, nums[0]));
//         int curMax = nums[0], globMax = curMax, curStart = 0, curEnd = 0, globStart = 0, globEnd = 0;
//         for(int i = 1; i < nums.length; i ++){
//             // curMax = Math.max(curMax + nums[i], nums[i]);
//             if(curMax + nums[i] > nums[i]){
//                 curMax = curMax + nums[i];
//                 curEnd =  i;
//             }
//             else{
//                 curMax = nums[i];
//                 curStart = i;
//                 curEnd = i;
//             }
//             if(curMax > globMax){
//                 globMax = curMax;
//                 globStart = curStart;
//                 globEnd = curEnd;
//             }
//             left.add(new Record(globStart, globEnd, globMax));
//         }
        
//         right.add(new Record(nums.length - 1, nums.length - 1, nums[nums.length - 1]));
//         curMax = nums[nums.length - 1]; globMax = curMax; curStart = nums.length - 1; curEnd = nums.length - 1; globStart = nums.length - 1; globEnd = nums.length - 1;
//         for(int i = nums.length - 2; i >= 0; i --){
//             // curMax = Math.max(curMax + nums[i], nums[i]);
//             if(curMax + nums[i] > nums[i]){
//                 curMax = curMax + nums[i];
//                 curStart = i;
//             }
//             else{
//                 curMax = nums[i];
//                 curStart = i;
//                 curEnd = i;
//             }
//             if(curMax > globMax){
//                 globMax = curMax;
//                 globStart = curStart;
//                 globEnd = curEnd;
//             }
//             right.add(new Record(globStart, globEnd, globMax));
//         }
//         Collections.reverse(right);
//         int max = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length - 1; i ++){
//             int lenLeft = left.get(i).end - left.get(i).start + 1;
//             int lenRight = right.get(i + 1).end - right.get(i + 1).start + 1;
//             if(lenLeft + lenRight >= k && left.get(i).maxVal + right.get(i + 1).maxVal > max){
//                 max = left.get(i).maxVal + right.get(i + 1).maxVal;
//             }
//         }
//         return max;
//     }
// }
