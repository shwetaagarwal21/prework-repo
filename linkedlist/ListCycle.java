/*
List Cycle
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Try solving it using constant additional space.
Example:
Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ListCycle {
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
