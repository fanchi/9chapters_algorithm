/*
Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?

Have you met this question in a real interview? Yes
Example
Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]
Tags 
Two Pointers LintCode Copyright
Related Problems 
Medium 3Sum 21 %
Easy Two Sum 28 %
*/
/*
两边之和大于第三边,两边之差小于第三边:
c > b - a
c < b + a
*/
public class Solution {
    /*
     * @param S: A list of integers
     * @return: An integer
     */
    //两边之和大于第三边,两边之差小于第三边:
    public int triangleCount(int[] S) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int ans = 0;
        for (int i = 0; i <= S.length - 3; i ++) {
            for (int j = i + 1; j <= S.length - 2; j ++) {
                for (int k = j + 1; k <= S.length - 1; k ++) {
                    if (S[i] + S[j] > S[k] && S[k] - S[i] < S[j]) {
                        ans ++;
                    }
                }
            }
        }
        return ans;
    }
}