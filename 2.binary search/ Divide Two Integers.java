/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return 2147483647

Have you met this question in a real interview? Yes
Example
Given dividend = 100 and divisor = 9, return 11.

Tags 
Binary Search
Related Problems 
Easy Plus One 31 %
Easy Add Binary 25 %
*/
/*
1. 基本思想是不断地减掉除数，直到为0为止。但是这样会太慢。

2. 我们可以使用2分法来加速这个过程。不断对除数*2，直到它比被除数还大为止。加倍的同时，也记录下cnt，将被除数减掉加倍后的值，并且结果+cnt。

因为是2倍地加大，所以速度会很快，指数级的速度。

3. 另外要注意的是：最小值的越界问题。对最小的正数取abs，得到的还是它。。。 因为最小的正数的绝对值大于最大的正数（INT）

所以，我们使用Long来接住这个集合就可以了。

抄的网上的答案，http://www.cnblogs.com/yuzhangcmu/p/4049170.html
但为什么是两层循环？ 不太理解。
*/
public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor == 0){
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if(dividend == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        long a = (long)(Math.abs((long) dividend));
        long b = (long)(Math.abs((long) divisor));
        int result = 0;
        while(a >= b){
            long tempB = b;
            int count = 1;
            while(a >= tempB){
                a -= tempB;
                result += count;
                tempB <<= 1;
                count <<= 1;
            }
        }
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        return isNeg ? -result : result;
    }
}