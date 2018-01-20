/*
Given a permutation which may contain repeated numbers, find its index in all the permutations of these numbers, which are ordered in lexicographical order. The index begins at 1.

Have you met this question in a real interview? Yes
Example
Given the permutation [1, 4, 2, 2], return 3.

Related Problems 
Medium Next Permutation II 34 %
*/
/*
死记硬背，肯定记不住。放弃吧。
*/
// https://zhengyang2015.gitbooks.io/lintcode/permutation_index_ii_198.html
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
        if(A == null || A.length < 2){
            return 1;
        }
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long facNumDup = 1;
        for(int i = A.length - 1; i >= 0; i --){
            // get the number of numbers which are smaller than current number from A[i + 1] to A[length - 1]
            int count = getCount(A, i);
            // ! of number of numbers following this number
            int pos = A.length - 1 - i;
            // number of duplicated numbers from current index to length - 1
            // 每遇到一个重复的数字就更新重复元素个数的阶乘的值
            if(map.containsKey(A[i])){
                map.put(A[i], map.get(A[i]) + 1);
                facNumDup *= map.get(A[i]);
            }
            else{
                map.put(A[i], 1);
            }
            int numDup = map.get(A[i]);
            ans += count * factorial(pos)/facNumDup;
        }
        return ans + 1;
    }
    private int getCount(int[] A, int i){
        int count = 0;
        for(int j = i + 1; j < A.length; j ++){
            if(A[i] > A[j]){
                count ++;
            }
        }
        return count;
    }
    private long factorial(int k){
        long ans = 1;
        for(int i = 1; i <= k; i ++){
            ans *= i;
        }
        return ans;
    }
}