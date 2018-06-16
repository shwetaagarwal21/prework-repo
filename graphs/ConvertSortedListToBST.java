/*
Convert Sorted List to Binary Search Tree


Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

    A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 

Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3
*/
/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode a) {
        if(a == null) return null;
        if(a.next == null){
            return new TreeNode(a.val);
        }
        if(a.next.next == null){
            TreeNode root = new TreeNode(a.val);
            root.right = new TreeNode(a.next.val);
            return root;
        }
        ListNode mid = getMiddle(a);
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(a);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    
    ListNode getMiddle(ListNode a){
        ListNode slow = a, fast = a, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
}
