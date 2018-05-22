/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode detectCycle(ListNode a) {
	    ListNode slow = a, fast = a.next;
	    while(fast != null && fast.next != null){
	        if(slow == fast) break;
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    if(slow == fast){
	        slow = a;
	        while(slow != fast.next){
	            slow = slow.next;
	            fast = fast.next;
	        }
	        return slow;
	    }
	    return null;
	}
}
