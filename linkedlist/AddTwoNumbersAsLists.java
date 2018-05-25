/*
Add Two Numbers as Lists
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode C = null, head = null;
        int sum = 0, carry = 0;
        ListNode temp;
        while(A != null || B != null){
            sum = ((A != null ? A.val : 0) + (B != null ? B.val : 0))%10;
            carry = ((A != null ? A.val : 0) + (B != null ? B.val : 0))/10;
            if(head == null){
                head = new ListNode(sum);
                C = head;
            }
            else{
                temp = new ListNode(sum);
                C.next = temp;
                C = C.next;
            }
        }
        if(carry > 0){
            C.next = new ListNode(carry);
        }
        //ListNode result = reverse(head);
        return head;
    }
    
    ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = null, next = head;
        while(next != null){
            curr = next;
            next = curr.next;
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}
