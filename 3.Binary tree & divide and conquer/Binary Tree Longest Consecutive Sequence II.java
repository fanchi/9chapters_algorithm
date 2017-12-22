/*
Given a binary tree, find the length of the longest consecutive sequence path.
The path could be start and end at any node in the tree

Have you met this question in a real interview? Yes
Example
    1
   / \
  2   0
 /
3
Return 4 // 0-1-2-3

Tags 
Binary Tree Depth First Search
Related Problems 
Medium Tree Longest Path With Same Value 13 %
Medium Binary Tree Longest Consecutive Sequence III 38 %
Easy Binary Tree Longest Consecutive Sequence 31 %
Hard Binary Tree Path Sum III 37 %
*/
// correct, copied
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    class MyType{
        int asc;
        int dsc;
        int turn;
        public MyType(int curAsc, int curDsc, int curTurn){
            this.asc = curAsc;
            this.dsc = curDsc;
            this.turn = curTurn;
        }
    }
    private int longest = Integer.MIN_VALUE;
    public int longestConsecutive2(TreeNode root) {
        helper(root);
        return longest;
    }
    
    private MyType helper(TreeNode root){
        if(root == null){
            return new MyType(0, 0, 0);
    }
    if(root.left == null && root.right == null){
        return new MyType(1, 1, 1);
    }
    MyType left = helper(root.left);
    MyType right = helper(root.right);
    //curAsc
    int curAscLeft = 1, curAscRight = 1;
    if(root.left != null && root.left.val == root.val + 1){
        curAscLeft = left.asc + 1;
    }
    if(root.right != null && root.right.val == root.val + 1){
        curAscRight = right.asc + 1;
    }
    //curDsc
    int curDscLeft = 1, curDscRight = 1;
    if(root.left != null && root.left.val == root.val - 1){
        curDscLeft = left.dsc + 1;
    }
    if(root.right != null && root.right.val == root.val - 1){
        curDscRight = right.dsc + 1;
    }
    //turn
    int curTurnClock = 1, curTurnCounter = 1;
    if(root.left != null && root.right != null){
        if(root.val == root.left.val + 1 && root.right.val == root.val + 1){
            curTurnClock = left.dsc + 1 + right.asc;
        }
        if(root.val == root.right.val + 1 && root.left.val == root.val + 1){
            curTurnCounter = right.dsc + 1 + left.asc;
        }
    }
    int longerAsc = Math.max(curAscLeft, curAscRight);
    int longerDsc = Math.max(curDscLeft, curDscRight);
    int longerTurn = Math.max(curTurnClock, curTurnCounter);
    if(longerAsc > longest){
        longest = longerAsc;
    }
    if(longerDsc > longest){
        longest = longerDsc;
    }
    if(longerTurn > longest){
        longest = longerTurn;
    }
    return new MyType(longerAsc, longerDsc, longerTurn);
}
}
// wrong,各种写不对。放弃了
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    int longest = Integer.MIN_VALUE;
    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        helper(root);
        return longest;
    }
    private class MyType {
        int up, down;
        private MyType(int up, int down) {
            this.up = up;
            this.down = down;
        }
    }
    private MyType helper(TreeNode root) {
        if (root == null) {
            longest = 0;
            return new MyType(0, 0);
        }
        if (root.left == null && root.right == null) {
            longest = 1;
            return new MyType(1, 1);
        }
        MyType left = helper(root.left);
        MyType right = helper(root.right);
        int down = 0, up = 0;
        // down
        if (root.left != null && root.val + 1 == root.left.val) {
            down = Math.max(down, left.down + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            down = Math.max(down, right.down + 1);
        }
        // up
        if (root.left != null && root.left.val + 1 == root.val) {
            up = Math.max(up, left.up + 1);
        }
        if (root.right != null && root.right.val + 1 == root.val) {
            up = Math.max(up, right.up + 1);
        }
        int turn = up + 1 + down;//我怀疑这样做并不对，因为root可能被加了两次。但答案是这么写的。
        longest = Math.max(longest, up);
        longest = Math.max(longest, down);
        longest = Math.max(longest, turn);
        return new MyType(up, down);
    } 
}