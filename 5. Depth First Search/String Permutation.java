/*
Given two strings, write a method to decide if one is a permutation of the other.

Have you met this question in a real interview? Yes
Example
abcd is a permutation of bcad, but abbe is not a permutation of abe

Tags 
Permutation String
Related Problems 
Medium String Permutation II 21 %
Easy Two Strings Are Anagrams
*/
public class Solution {
    /*
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        char[] chars = new char[256];
        for (int i = 0; i < A.length(); i ++) {
            chars[A.charAt(i)] ++;
        }
        for (int i = 0; i < B.length(); i ++) {
            chars[B.charAt(i)] --;
        }
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}