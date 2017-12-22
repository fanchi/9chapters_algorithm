/*
Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

n books list in a row and each person can claim a continous range of the n books. For example one copier can copy the books from ith to jth continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).

They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?

Have you met this question in a real interview? Yes
Example
Given array A = [3,2,4], k = 2.

Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )
*/
public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int maxPage = pages[0], sumPage = 0;
        for (int i = 0; i < pages.length; i ++) {
            sumPage += pages[i];
            maxPage = Math.max(maxPage, pages[i]);
        }
        int left = maxPage, right = sumPage;
        // search the maximum page one can copy.
        // The time is the maximum number of pages one can copy
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (getPerson(pages, mid) > k) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        if (getPerson(pages, left) <= k) {
            return left;
        }
        else {
            return right;
        }
    }
    private int getPerson(int[] pages, int num) {
        int ans = 1, cummulate = pages[0];
        for (int i = 1; i < pages.length; i ++) {
            cummulate += pages[i];
            if (cummulate > num) {
                ans ++;
                i --;
                cummulate = 0;
            }
        }
        return ans;
    }
}