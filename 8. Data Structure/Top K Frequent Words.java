/*
Given a list of words and an integer k, return the top k frequent words in the list.

 Notice
You should order the words by the frequency of them in the return list, the most frequent one comes first. If two words has the same frequency, the one with lower alphabetical order come first.

Have you met this question in a real interview? Yes
Example
Given

[
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
]
for k = 3, return ["code", "lint", "baby"].

for k = 4, return ["code", "lint", "baby", "yes"],

Challenge 
Do it in O(nlogk) time and O(n) extra space.

Extra points if you can do it in O(n) time with O(k) extra space approximation algorithms.

Tags 
Hash Table Heap Priority Queue
Related Problems 
Hard Top K Frequent Words II 17 %
Medium Top K Frequent Words (Map Reduce) 22 %
Medium Top k Largest Numbers II 29 %
Medium Top k Largest Numbers 35 %
*/

public class Solution {
    /*
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if (words == null || words.length == 0 || k == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<>();
        for (String str: words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            }
            else {
                map.put(str, 1);
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<Node>(k, new MyComp());
        for (String key: map.keySet()) {
            Node node = new Node(key, map.get(key));
            pq.offer(node);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        String[] ans = new String[pq.size()];
        int ind = ans.length - 1;
        while (!pq.isEmpty()) {
            ans[ind --] = pq.poll().word;
        }
        return ans;
    }
    private class Node {
        String word;
        int count;
        private Node (String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    class MyComp implements Comparator<Node> {
        public int compare(Node n1, Node n2) {
            if (n1.count == n2.count) {
                return n2.word.compareTo(n1.word);
            }
            else {
                return n1.count - n2.count;
            }
        }
    }
}