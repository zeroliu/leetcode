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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode b = fakeHead;
        ListNode f = head;
        boolean isDuplicated = false;
        int val = 0;
        while (f != null) {
            if (isDuplicated) {
                if (f.val != val) {
                    isDuplicated = false;
                    b.next = f;
                }
            }
            if (!isDuplicated && f.next != null) {
                if (f.next.val != f.val) {
                    b = f;
                } else {
                    isDuplicated = true;
                    val = f.val;
                }
            }
            f = f.next;
        }
        if (isDuplicated) {
            b.next = null;
        }
        return fakeHead.next;
    }
}
