/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Have you met this question in a real interview? Yes
Example
add(1); add(3); add(5);
find(4) // return true
find(7) // return false
Tags 
LinkedIn Hash Table Data Structure Design
Related Problems 
Medium Two Sum - Input array is sorted 47 %
Medium Two Sum - Difference equals to target 26 %
Medium Two Sum - Less than or equal to target 39 %
Medium Two Sum - Unique pairs 34 %
Medium Two Sum - Closest to target 43 %
Medium Two Sum - Greater than target 38 %
Easy Two Sum 28 %
*/
public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        }
        else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        if (map.size() == 0) {
            return false;
        }
        for (int key: map.keySet()) {
            int val = value - key;
            if (val == key) {
                if (map.get(val) > 1) {
                    return true;
                }
            }
            else {
                if (map.containsKey(val)) {
                    return true;
                }
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);