/*
Given two 1d vectors, implement an iterator to return their elements alternately.

Have you met this question in a real interview? Yes
Example
Given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Tags 
Google
Related Problems 
Medium Flatten 2D Vector 45 %
Medium Zigzag Iterator II 33 %
Medium Flatten Nested List Iterator 28 %
Hard Binary Search Tree Iterator 36 %
*/
public class ZigzagIterator {
    /*
    * @param v1: A 1d vector
    * @param v2: A 1d vector
    */
    int[] inds;
    int ind;
    List<Integer> v1, v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do itialization if necessary
        this.inds = new int[2];
        this.ind = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        int val = 0;
        if (inds[0] >= v1.size()) {
            val = v2.get(inds[1]);
            inds[1] ++;
            return val;
        }
        if (inds[1] >= v2.size()) {
            val = v1.get(inds[0]);
            inds[0] ++;
            return val;
        }
        if (ind == 0 && inds[0] < v1.size()) {
            val = v1.get(inds[0]);
            inds[0] ++;
            ind = (ind + 1) % 2;
        }
        else if (ind == 1 && inds[1] < v2.size()){
            val = v2.get(inds[1]);
            inds[1] ++;
            ind = (ind + 1) % 2;
        }
        return val;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        if (inds[0] >= v1.size() && inds[1] >= v2.size()) {
            return false;
        }
        else {
            return true;
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */