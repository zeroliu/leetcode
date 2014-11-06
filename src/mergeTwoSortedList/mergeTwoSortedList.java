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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        ListNode node = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            } else {
                node = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = node;
                current = head;
            } else {
                current.next = node;
                current = node;
            }
        }
        node = (l1 == null) ? l2 : l1;
        if (current == null) {
            return node;
        }
        current.next = node;
        return head;
    }
}
