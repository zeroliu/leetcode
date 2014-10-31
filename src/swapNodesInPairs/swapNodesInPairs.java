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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        head = fakeHead;
        ListNode parent = fakeHead;
        ListNode left = fakeHead.next;
        ListNode right = left.next;
        while (left != null && right != null) {
            parent.next = swapNode(left, right);
            parent = left;
            left = parent.next;
            if (left != null) {
                right = left.next;
            } else {
                right = null;
            }
        }
        return head.next;
    }
    
    ListNode swapNode(ListNode left, ListNode right) {
        left.next = right.next;
        right.next = left;
        return right;
    }
}
