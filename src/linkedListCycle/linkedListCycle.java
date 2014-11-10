/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        while (a != null && b!= null) {
            a = a.next;
            b = b.next;
            if (b != null) {
                b = b.next;
            } else {
                return false;
            }
            if (a == b) {
                return true;
            }
        }
        return false;
    }
}
