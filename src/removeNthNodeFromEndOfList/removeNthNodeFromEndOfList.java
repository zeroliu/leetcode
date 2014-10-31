/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode sec = head;
        for (int i=0; i<n-1; i++) {
            sec = sec.next;
            if (sec == null) {
                return head;
            }
        }
        
        if (sec.next == null) {
            //sec is the last, head to remove
            head = head.next;
            return head;
        }
        while (sec.next.next != null) {
            first = first.next;
            sec = sec.next;
        }
        first.next = first.next.next;
        return head;
    }
}
