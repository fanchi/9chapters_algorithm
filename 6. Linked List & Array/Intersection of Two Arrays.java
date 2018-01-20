/*
Given two arrays, write a function to compute their intersection.

 Notice
Each element in the result must be unique.
The result can be in any order.
Have you met this question in a real interview? Yes
Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Challenge 
Can you implement it in three different algorithms?

Tags 
Sort Two Pointers Hash Table Binary Search
Related Problems 
Easy Intersection of Two Arrays II 23 %
Medium Count of Smaller Number 20 %
Easy Merge Two Sorted Arrays 35 %
*/
/*
要会多种解法
1. hash O(n+m) time, space o(min(n,m))
2. merge two sorted array o(nlogn + mlogm), O(1)
3. binary search (n < m) O(nlogn + mlogn), O(1)
*/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int ind1 = 0, ind2 = 0;
        while (ind1 < nums1.length && ind2 < nums2.length) {
            if (nums1[ind1] < nums2[ind2]) {
                ind1 ++;
            }
            else if (nums1[ind1] > nums2[ind2]){
                ind2 ++;
            }
            else {
                if (!list.contains(nums1[ind1])) {
                    list.add(nums1[ind1]);
                }
                ind1 ++;
                ind2 ++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

///////////

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        for (int val: nums1) {
            set.add(val);
        }
        Set<Integer> ansSet = new HashSet<>();
        for (int val: nums2) {
            if (set.contains(val)) {
                ansSet.add(val);
            }
        }
        int[] ans = new int[ansSet.size()];
        int index = 0;
        for (int val: ansSet) {
            ans[index ++] = val;
        }
        return ans;
    }
}

////////

