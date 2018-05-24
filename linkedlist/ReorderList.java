/*
Reorder List
Given a singly linked list
L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:
L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.
For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReorderList {
    public ListNode reorderList(ListNode A) {
        ListNode slow = A, fast = A.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node1 = A, node2 = slow.next;
        slow.next = null;
        node2 = reverseList(node2);
        A = new ListNode(0);
        ListNode curr = A;
        while(node1 != null || node2 != null){
            if(node1 != null){
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next; 
            }
            if(node2 != null){
                curr.next = node2;
                curr = curr.next;
                node2 = node2.next;
            }
        }
        return A.next;
    }
    
    ListNode reverseList(ListNode node){
        if(node == null) return null;
        ListNode prev = null, curr = null, next = node;
        while(next != null){
            curr = next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}
