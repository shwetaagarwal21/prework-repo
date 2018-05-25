/*
Swap List Nodes in pairs
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {
        if(A == null || A.next == null) return A;
        ListNode prev = A, curr = A.next;
        ListNode head = A.next;
        ListNode temp;
        ListNode next;
        while(true) {
            next = curr.next;
            curr.next = prev;
            if(next == null || next.next == null){
                prev.next = next;
                break;
            }
            prev.next = next.next;
            
            prev = next;
            curr = prev.next;
        }
        return head;
    }
    
    public ListNode swapPairs(ListNode A) {
        if(A == null || A.next == null) return A;
        ListNode temp = A;
        while(temp != null && temp.next != null){
            int tt = temp.val;
            temp.val = temp.next.val;
            temp.next.val = tt;
            temp = temp.next.next;
        }
        return A;
    }
}
