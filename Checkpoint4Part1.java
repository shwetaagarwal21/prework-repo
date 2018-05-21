public class Checkpoint4Part1 {
    public ListNode subtract(ListNode A) {
        ListNode slow = A, fast = A, prev_slow = A, mid = null, second_half = null;
        ListNode first_half = A, second_half2= null;
        if (A != null && A.next != null) {
            while (fast != null && fast.next != null) {
                prev_slow = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast != null){
                mid = slow;
                slow = slow.next;
            }
            second_half = slow;
            prev_slow.next = null;
            second_half = reverse(second_half);
            second_half2 = second_half;
            while(second_half2 != null){
                first_half.val = second_half2.val - first_half.val;
                first_half = first_half.next;
                second_half2 = second_half2.next;
            }
            second_half = reverse(second_half);
            if(mid != null){
                prev_slow.next = mid;
                mid.next = second_half;
            }else{
                prev_slow.next = second_half;
            }
        }
        return A;
    }
    
    ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode current = node;
		ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
