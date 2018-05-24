/*
Linked List Duplicate Removal
Example: Given a linked list 12->11->12->21->41->43->21, the program should output: 12->11->21->41->43
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class LinkedListDuplicateRemoval {

 // time complexity: O(n^2)
 // space complexity: O(1)
 public static LinkedListNode linkedListDuplicateRemoval(LinkedListNode head) {
    LinkedListNode curr = head;
    LinkedListNode prev, next;
    while(curr != null && curr.next != null){
      prev = curr;
      next = curr.next;
      while(next != null){
        while(next != null && next.val == curr.val){
          prev.next = next.next;
          next = next.next;
        }
        if(next == null)
        break;
      }
      curr = curr.next;
    }
    return head;
  }
  
  // time complexity: O(n^2)
  // space complexity: O(1)
  public static LinkedListNode linkedListDuplicateRemoval(LinkedListNode head) {
    if(head == null) return null;
    Map map = new HashMap();
    LinkedListNode curr = head;
    LinkedListNode prev;
    map.put(curr.val, 1);
    while(curr != null && curr.next != null){
      prev = curr;
      curr = curr.next;
      if(map.containsKey(curr.next.val)){
        prev.next = curr.next;
        curr = prev;
      }else{
        map.put(curr.next.val, 1);
      }
    }
    return head;
  }
  
}

