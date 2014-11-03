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
    public ListNode partition(ListNode head, int x) {
        ListNode other = null;
        ListNode otherTail = null;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode current = fakeHead;
        
        while (current.next != null) {
        	if (current.next.val >= x) {
        		if (other == null) {
        			other = current.next;
        			otherTail = other;
        		} else {
        			otherTail.next = current.next;
        			otherTail = otherTail.next;
        		}
        		current.next = current.next.next;
        		otherTail.next = null;
            } else {
            	current = current.next;
            }
        }
        current.next = other;
        return fakeHead.next;
    }
}
