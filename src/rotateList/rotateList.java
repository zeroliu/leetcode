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
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        int count = 1;
        while(tail.next != null) {
            tail = tail.next;
            count ++;
        }
        n = n % count;
        if (n == 0) { return head; }
        int toMove = count - n;
        ListNode newTail = head;
        for (int i=1; i<toMove; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;
        head = newHead;
        
        return head;
    }
}
