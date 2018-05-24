/*
K reverse linked list
Given a singly linked list and an integer K, reverses the nodes of the
list K at a time and returns modified linked list.
NOTE : The length of the list is divisible by K
Example :
Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,
You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5
Try to solve the problem using constant extra space.
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class KReverseLinkedList {
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
