/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        ListNode prev = null, curr = null, next = A;
        int count = 0;
        while(next != null && count < B){
            curr = next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            count++;
        }
        if(next != null)
            A.next = reverseList(next, B);
        return prev;
    }
}
