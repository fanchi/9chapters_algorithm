/*
Given two arrays, write a function to compute their intersection.

 Notice
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Have you met this question in a real interview? Yes
Example
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Challenge 
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Tags 
Sort Two Pointers Hash Table Binary Search
Related Problems 
Easy Intersection of Two Arrays 24 %
Medium Count of Smaller Number 20 %
Easy Merge Two Sorted Arrays 35 %
*/
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        int ind1 = 0, ind2 = 0;
        while (ind1 < nums1.length && ind2 < nums2.length) {
            if (nums1[ind1] < nums2[ind2]) {
                ind1 ++;
            }
            else if (nums1[ind1] > nums2[ind2]) {
                ind2 ++;
            }
            else {
                list.add(nums1[ind1]);
                ind1 ++;
                ind2 ++;
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i ++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}

//////////////

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = findFirst(nums2, nums1[0]);
        if(index == - 1){
            return new int[0];
        }
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums1.length; i ++){
            if(hash.containsKey(nums1[i])){
                hash.put(nums1[i], hash.get(nums1[i]) + 1);
            }
            else{
                hash.put(nums1[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = index; i < nums2.length; i ++){
            if(nums2[i] > nums1[nums1.length - 1]){
                break;
            }
            if(hash.containsKey(nums2[i]) && hash.get(nums2[i]) != 0){
                list.add(nums2[i]);
                hash.put(nums2[i], hash.get(nums2[i]) - 1);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i ++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    private int findFirst(int[] array, int target){
        int start = 0, end = array.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(array[mid] >= target){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        if(array[start] >= target){
            return start;
        }
        if(array[end] >= target){
            return end;
        }
        return -1;
    }
}