/*
Implement strStr function in O(n + m) time.

strStr return the first index of the target string in a source string. The length of the target string is m and the length of the source string is n.
If target does not exist in source, just return -1.

Have you met this question in a real interview? Yes
Example
Given source = abcdef, target = bcd, return 1.

Tags 
Hash Table
Related Problems 
Easy strStr 18 %
*/
public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public final int BASE = 1000000;
    public int strStr2(String source, String target) {
        // Write your code here
        if(source == null || target == null || source.length () < target.length()){
            return -1;
        }
        if(target.length() == 0){
            return 0;
        }
        int m = target.length();
        int targetHash = 0;
        for(int i = 0; i < m; i ++){
            targetHash = (targetHash * 33 + target.charAt(i)) % BASE;
        }
        
        int power = 1;
        for(int j = 0; j < m; j++){
            power = power * 33 % BASE;
        }
        
        int sourceHash = 0;
        // 0 to m - 1
        for(int i = 0; i < m ; i++){
            sourceHash = (sourceHash * 33 + source.charAt(i)) % BASE;
        }
        
        // from m - 1
        for(int i = m - 1; i < source.length(); i++){
            if(sourceHash == targetHash){
                if(source.substring(i - m + 1, i + 1).equals(target)){
                    return i -m + 1;
                }
            }
            if(i == source.length() - 1){
                break;
            }
            sourceHash = (sourceHash * 33 + source.charAt(i + 1)) % BASE;
            int toMinus = (source.charAt(i - m + 1) * power) % BASE;
            sourceHash -= toMinus;
            if(sourceHash < 0){
                sourceHash += BASE;
            }
        }
        return - 1;
    }
}