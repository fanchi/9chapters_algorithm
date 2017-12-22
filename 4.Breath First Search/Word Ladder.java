/*
Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
 Notice
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Have you met this question in a real interview? Yes
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Tags 
LinkedIn Breadth First Search
Related Problems 
Hard Word Ladder II 20 %
*/
public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start == null || end == null || start.length() == 0 || end.length() == 0) {
            return 0;
        }
        dict.add(start);
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps ++;
            for (int i = 0; i < size; i ++) {
                String str = queue.poll();
                if (str.equals(end)) {
                    return steps;
                }
                for (String word: getNeighbors(str, dict)) {
                    if (!visited.contains(word)) {
                        queue.offer(word);
                        visited.add(word);
                    }
                }
            }
        }
        return 0;
    }
    private Set<String> getNeighbors(String str, Set<String> dict) {
        Set<String> ans = new HashSet<>();
        for (String word: dict) {
            if (differBy1(word, str)) {
                ans.add(word);
            }
        }
        return ans;
    }
    private boolean differBy1(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int differ = 0;
        for (int i = 0; i < str1.length(); i ++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                differ ++;
                if (differ > 1) {
                    return false;
                }
            }
        }
        return differ == 1;
    }
}