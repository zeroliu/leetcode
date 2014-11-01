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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        
        ListNode current = fakeHead;
        ListNode start = fakeHead;
        ListNode kStep = current;
        
        while (kStep != null) {
            for (int i=0; i<k; i++) {
                kStep = kStep.next;
                if (kStep == null) {
                    break;
                }
            }
            start = current.next;
            if (start == null || kStep == null) {
                break;
            }
            current.next = reverse(start, kStep);
            current = start;
            kStep = current;
        }
        return fakeHead.next;
    }
    
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode source = tail.next;
        ListNode current = head;
        ListNode next = head.next;
        
        while (current != tail) {
            current.next = source;
            source = current;
            current = next;
            next = current.next;
        }
        tail.next = source;
        
        return tail;
    }
}
