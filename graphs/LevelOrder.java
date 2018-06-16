/*
Level Order
Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).
Given binary tree

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
*/
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(A == null) return list;
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQ = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        Q.add(A);
        //Q.add(null);
        while(!Q.isEmpty()){
            TreeNode n = Q.remove();
            level.add(n.val);
            if(n.left != null){
                nextQ.add(n.left);
            }
            if(n.right != null){
                nextQ.add(n.right);
            }
            if(Q.isEmpty()){
                Q = nextQ;
                nextQ = new LinkedList<TreeNode>();
                list.add(level);
                level = new ArrayList<Integer>();
            }
        }
        return list;
    }
}
