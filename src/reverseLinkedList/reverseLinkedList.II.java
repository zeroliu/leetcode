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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        if (m == 1) {
            return reverseBetween(head, n-m+1);
        }
        
        ListNode current = head;
        for (int i=2; i<m; i++) {
            current = current.next;        
        }
        current.next = reverseBetween(current.next, n-m+1);
        return head;
    }
    
    ListNode reverseBetween(ListNode head, int range) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current;
        for (int i=0; i<range; i++) {
            current = next;
            next = current.next;
            current.next = prev;
            prev = current;
        }
        head.next = next;
        return current;
    }
}
