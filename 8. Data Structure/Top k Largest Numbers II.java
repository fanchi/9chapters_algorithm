/*
Implement a data structure, provide two interfaces:

add(number). Add a new number in the data structure.
topk(). Return the top k largest numbers in this data structure. k is given when we create the data structure.
Have you met this question in a real interview? Yes
Example
s = new Solution(3);
>> create a new data structure.
s.add(3)
s.add(10)
s.topk()
>> return [10, 3]
s.add(1000)
s.add(-99)
s.topk()
>> return [1000, 10, 3]
s.add(4)
s.topk()
>> return [1000, 10, 4]
s.add(100)
s.topk()
>> return [1000, 100, 10]
Tags 
Heap Priority Queue
Related Problems 
Hard Top K Frequent Words II 17 %
Medium Top k Largest Numbers 35 %
Medium Top K Frequent Words 19 %
*/
public class Solution {
    int k;
    PriorityQueue<Integer> minHeap;
    public Solution(int k) {
        // initialize your data structure here.
        this.k = k;
        this. minHeap = new PriorityQueue<Integer>();
    }

    public void add(int num) {
        // Write your code here
        minHeap.offer(num);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        if (minHeap.size() == 0) {
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        while (!minHeap.isEmpty()) {
            stack.push(minHeap.poll());
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        for (int i = list.size() - 1; i >= 0; i --) {
            minHeap.offer(list.get(i));
        }
        return list;
    }
};