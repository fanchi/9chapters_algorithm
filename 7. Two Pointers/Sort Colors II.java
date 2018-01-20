/*
Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

 Notice
You are not suppose to use the library's sort function for this problem.

k <= n

Have you met this question in a real interview? Yes
Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].

Challenge 
A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?

Tags 
Sort Two Pointers
Related Problems 
Medium Wiggle Sort 40 %
Medium Wiggle Sort II 25 %
Medium Sort Colors 36 %
*/
public class Solution {
    /*
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length < k) {
            return;
        }
        int left = 0, right = colors.length - 1, i = 0;
        for (int c = 0; c < k; c ++) {
            int leftC = c + 1, rightC = k - c;
            while (i <= right) {
                int val = colors[i];
                if (val == leftC) {
                    swap(colors, left, i);
                    i ++;
                    left ++;
                }
                else if (val == rightC) {
                    swap(colors, right, i);
                    right --;
                }
                else {
                    i ++;
                }
            }
            i = left;
        }
    }
    private void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}