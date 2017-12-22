/*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.

The node has an extra attribute parent which point to the father of itself. The root's parent is null.

Have you met this question in a real interview? Yes
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7

Tags 
LintCode Copyright Binary Tree
Related Problems 
Medium Lowest Common Ancestor III 25 %
Medium Lowest Common Ancestor 40 %
*/
/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        List<ParentTreeNode> listA = new ArrayList<>();
        List<ParentTreeNode> listB = new ArrayList<>();
        ParentTreeNode curt = A;
        while (curt != null) {
            listA.add(curt);
            curt = curt.parent;
        }
        curt = B;
        while (curt != null) {
            listB.add(curt);
            curt = curt.parent;
        }
        int i = listA.size() - 1, j = listB.size() - 1;
        ParentTreeNode prev = null;
        while (i >= 0 && j >= 0) {
            if (listA.get(i) == listB.get(j)) {
                prev = listA.get(i);
                i --;
                j --;
            }
            else {
                break;
            }
        }
        return prev;
    }
}