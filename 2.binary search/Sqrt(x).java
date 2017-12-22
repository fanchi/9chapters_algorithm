/*
Implement int sqrt(int x).

Compute and return the square root of x.

Have you met this question in a real interview? Yes
Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3

Challenge 
O(log(x))

Tags 
Binary Search Mathematics Facebook
Related Problems 
Medium Sqrt(x) II 32 %
Medium Pow(x, n) 35 %
Easy First Position of Target 33 %
*/
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        int start = 1, end = x;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if ((long)mid * mid <= (long)x) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if ((long)end * end <= (long)x) {
            return end;
        }
        else {
            return start;
        }
    }
}