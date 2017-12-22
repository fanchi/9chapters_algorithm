/*
It's follow up problem for Binary Tree Longest Consecutive Sequence II

Given a k-ary tree, find the length of the longest consecutive sequence path.
The path could be start and end at any node in the tree

Have you met this question in a real interview? Yes
Example
An example of test data: k-ary tree 5<6<7<>,5<>,8<>>,4<3<>,5<>,3<>>>, denote the following structure:


     5
   /   \
  6     4
 /|\   /|\
7 5 8 3 5 3

Return 5, // 3-4-5-6-7
Tags 
Depth First Search
Related Problems 
Medium Binary Tree Longest Consecutive Sequence III 38 %
Medium Binary Tree Longest Consecutive Sequence II 32 %
Easy Binary Tree Longest Consecutive Sequence 31 %
Medium Longest Consecutive Sequence 34 %
*/
/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    private int longest = 1;
    private class Node{
        private int asc, des, turn;
        private Node(int asc, int des, int turn){
            this.asc = asc;
            this.des = des;
            this.turn = turn;
        }
    }
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        // if(root == null){
        //     return 0;
        // }
        helper(root);
        return longest;
    }
    private Node helper(MultiTreeNode root){
        // if(root.children.size() == 0){
        //     return new Node(1, 1, 1);
        // }
        if(root == null){
            return new Node(0,0,0);
        }
        ArrayList<Node> childNodes = new ArrayList<>();

        for(int i = 0; i < root.children.size(); i ++){
            childNodes.add(helper(root.children.get(i)));
        }
        int curAsc = 0, curDes = 0, curTurn = 1;
        for(int cur = 0; cur < childNodes.size(); cur ++){
            // acs
            if(root.children.get(cur) != null && root.val == root.children.get(cur).val - 1){
                curAsc = Math.max(childNodes.get(cur).asc + 1, curAsc);
            }
            // des
            if(root.children.get(cur) != null && root.val == root.children.get(cur).val + 1){
                curDes = Math.max(childNodes.get(cur).des + 1, curDes);
            }
            //turns
            curTurn = Math.max(curTurn, curAsc + 1 + curDes);
            // turns
            for(int other = 0; other < childNodes.size(); other ++){
                if(other == cur){
                    continue;
                }
                if(root.children.get(other) != null && root.children.get(cur) != null){
                    if(root.children.get(other).val + 1 == root.val && root.val + 1 == root.children.get(cur).val){
                        curTurn = Math.max(curTurn, childNodes.get(other).des + childNodes.get(cur).asc + 1);
                    }
                    if(root.val == root.children.get(cur).val + 1 && root.children.get(other).val == root.val + 1){
                        curTurn = Math.max(curTurn, childNodes.get(other).asc + childNodes.get(cur).des + 1);
                    }
                }
            }
        }//for cur
        //curTurn = Math.max(curTurn, curAsc + curDes + 1);
        longest = Math.max(longest, Math.max(curTurn, Math.max(curAsc, curDes)));
        return new Node(curAsc, curDes, curTurn);
    }
}