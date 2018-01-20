/*
Given an array of integers, find two numbers that their difference equals to a target value.
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

 Notice
It's guaranteed there is only one available solution

Have you met this question in a real interview? Yes
Example
Given nums = [2, 7, 15, 24], target = 5
return [1, 2] (7 - 2 = 5)

Tags 
Two Pointers Hash Table
Related Problems 
Medium Two Sum - BST edtion 27 %
Medium Two Sum - Input array is sorted 47 %
Medium Two Sum - Less than or equal to target 39 %
Easy Two Sum - Data structure design 35 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Greater than target 38 %
Easy Two Sum 28 %
*/

// 用pointer，是同向双pointer

// my solution
public class Solution {
    /*
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i] - target)) {
                int ind = map.get(nums[i] - target);
                int[] ans = new int[2];
                ans[0] = Math.min(ind, i) + 1;
                ans[1] = Math.max(ind, i) + 1;
                return ans;
            }
            else if (map.containsKey(target + nums[i])) {
                int ind = map.get(target + nums[i]);
                int[] ans = new int[2];
                ans[0] = Math.min(ind, i) + 1;
                ans[1] = Math.max(ind, i) + 1;
                return ans;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}

// jiuzhang solution
/**
* 本参考程序来自九章算法，由 @九章算法 提供。版权所有，转发请注明出处。
* - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
* - 现有的面试培训课程包括：九章算法班，系统设计班，算法强化班，Java入门与基础算法班，Android 项目实战班，
* - Big Data 项目实战班，算法面试高频题班, 动态规划专题班
* - 更多详情请见官方网站：http://www.jiuzhang.com/?source=code
*/ 

class Pair {
    public int idx, num;
    public Pair(int i, int n) {
        this.idx = i;
        this.num = n;
    }
}

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int[] indexs = new int[2];
        if (nums == null || nums.length < 2)
            return indexs;

        if (target < 0)
            target = -target;

        int n = nums.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; ++i)
            pairs[i] = new Pair(i, nums[i]);

        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return p1.num - p2.num;
            } 
        });

        int j = 0;
        for (int i = 0; i < n; ++i) {
            if (i == j)
                j ++;
            while (j < n && pairs[j].num - pairs[i].num < target)
                j ++;

            if (j < n && pairs[j].num - pairs[i].num == target) {
                indexs[0] = pairs[i].idx + 1;
                indexs[1] = pairs[j].idx + 1;
                if (indexs[0] > indexs[1]) {
                    int temp = indexs[0];
                    indexs[0] = indexs[1];
                    indexs[1] = temp;
                }
                return indexs;
            }
        }
        return indexs;
    }
}