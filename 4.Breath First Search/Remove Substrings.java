/*
Given a string s and a set of n substrings. You are supposed to remove every instance of those n substrings from s so that s is of the minimum length and output this minimum length.

Have you met this question in a real interview? Yes
Example
Given s = ccdaabcdbb, substrs = ["ab", "cd"]
Return 2

Explanation: 
ccdaabcdbb -> ccdacdbb -> cabb -> cb (length = 2)

Tags 
Amazon String
*/
public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (dict == null || dict.size() == 0) {
            return s.length();
        }
        int min = s.length();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            String curStr = queue.poll();
            min = Math.min(curStr.length(), min);
            Set<String> subs = getSub(curStr, dict);
            for (String str: subs) {
                if (!visited.contains(str)){
                    queue.offer(str);
                    visited.add(str);
                }
            }
        }
        return min;
    }
    private Set<String> getSub(String s, Set<String> dict) {
        Set<String> set = new HashSet<>();
        if (s == null || s.length() == 0) {
            return set;
        }
        for (String str: dict) {
            int ind = s.indexOf(str);
            while (ind != - 1) {
                String tempStr = s.substring(0, ind) + s.substring(ind + str.length());
                set.add(tempStr);
                ind = s.indexOf(str, ind + str.length());
            }
        }
        return set;
    }
}