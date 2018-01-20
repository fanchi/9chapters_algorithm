/*
Follow up Zigzag Iterator: What if you are given k 1d vectors? How well can your code be extended to such cases? The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".

Have you met this question in a real interview? Yes
Example
Given k = 3 1d vectors:

[1,2,3]
[4,5,6,7]
[8,9]
Return [1,4,8,2,5,9,3,6,7].

Tags 
Google
Related Problems 
Medium Zigzag Iterator 44 %
Medium Flatten Nested List Iterator 28 %
Hard Binary Search Tree Iterator 36 %
*/
public class ZigzagIterator2 {
    /**
     * @param vecs a list of 1d vectors
     */
    int[] inds;
    int curInd;
    ArrayList<ArrayList<Integer>> lists;
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        this.inds = new int[vecs.size()];
        this.curInd = 0;
        lists = vecs;
    }

    public int next() {
        // Write your code here
        // while (inds[curInd] >= lists.get(curInd).size()) {
        //     curInd = (curInd + 1) % lists.size();
        // }
        int val = lists.get(curInd).get(inds[curInd]);
        inds[curInd] ++;
        curInd = (curInd + 1) % lists.size();
        return val;
    }

    public boolean hasNext() {
        // Write your code here
        if (inds[curInd] < lists.get(curInd).size()) {
            return true;
        }
        int total = 0;
        while (true) {
            curInd = (curInd + 1) % lists.size();
            if (inds[curInd] < lists.get(curInd).size()) {
                return true;
            }
            total ++;
            if (total == lists.size()) {
                return false;
            }
        }
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */