/*
For a given source string and a target string, you should output the first index(from 0) of target string in source string.

If target does not exist in source, just return -1.

Have you met this question in a real interview? Yes
Clarification
Do I need to implement KMP Algorithm in a real interview?

Not necessary. When you meet this problem in a real interview, the interviewer may just want to test your basic implementation ability. But make sure you confirm with the interviewer first.
Example
If source = "source" and target = "target", return -1.

If source = "abcdabcdefg" and target = "bcd", return 1.

Challenge 
O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)

Tags 
String Basic Implementation Facebook
Related Problems 
Hard strStr II 25 %
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        int len = 0, i;
        for (i = 0; i < source.length(); i ++) {
            len = 0;
            for (len = 0; len < target.length() && i + len < source.length(); len ++) {
                if (source.charAt(i + len) != target.charAt(len)) {
                    break;
                }
            }
            if (len == target.length()) {
                break;
            }
        }
        return len == target.length() ? i : -1;
    }
}