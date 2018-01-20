/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 Notice
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Have you met this question in a real interview? Yes
Example
"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Challenge 
O(n) time without extra memory.

Tags 
Two Pointers String Uber Zenefits Facebook
Related Problems 
Easy Palindromic Ranges 23 %
Medium Sum of first K even-length Palindrome numbers 40 %
Easy Palindrome Number 36 %
Easy Longest Palindrome 26 %
Medium Palindrome Linked List 29 %
Medium Longest Palindromic Substring 28 %
*/

// Clarify!!!

public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!valid(s.charAt(left))) {
                left ++;
                continue;
            }
            if (!valid(s.charAt(right))) {
                right --;
                continue;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            else {
                left ++;
                right --;
            }
        }
        return true;
    }
    private boolean valid(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}