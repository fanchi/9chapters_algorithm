/*
Implement an iterator to flatten a 2d vector.

Have you met this question in a real interview? Yes
Example
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Tags 
Airbnb Google Zenefits Twitter
Related Problems 
Medium Zigzag Iterator 44 %
Medium Flatten Nested List Iterator 28 %
Easy Flatten Binary Tree to Linked List 33 %
Easy Flatten List 31 %
*/
public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> it1;
    Iterator<Integer> it2;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.it1 = vec2d.iterator();
        if (!it1.hasNext()) {
            it2 = null;
        }
        else {
            it2 = it1.next().iterator();
        }
    }

    @Override
    public Integer next() {
        // Write your code here
        return it2.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        if (it2 == null || !it2.hasNext() && !it1.hasNext()) {
            return false;
        }
        if (!it2.hasNext() && it1.hasNext()) {
            it2 = it1.next().iterator();
        }
        return true;
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */