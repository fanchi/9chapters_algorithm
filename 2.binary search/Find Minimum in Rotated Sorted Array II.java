/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

 Notice
The array may contain duplicates.

Have you met this question in a real interview? Yes
Example
Given [4,4,5,6,7,0,1,2] return 0.

Tags 
Divide and Conquer Binary Search
Related Problems 
Medium Find Minimum in Rotated Sorted Array 39 %
Medium Search in Rotated Sorted Array II 40 %
*/
// 考的是最坏情况
// 111111111111110111111111
public class Solution {
    public int findMin(int[] num) {
        //  这道题目在面试中不会让写完整的程序
        //  只需要知道最坏情况下 [1,1,1....,1] 里有一个0
        //  这种情况使得时间复杂度必须是 O(n)
        //  因此写一个for循环就好了。
        //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
        //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min)
                min = num[i];
        }
        return min;
    }
}