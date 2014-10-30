package addTwoNumbers;

/**
 * Created by zeroliu on 10/25/14.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int inc = 0;
        ListNode result = null;
        ListNode current = result;
        while (l1 != null || l2 != null) {
            int sum = getValueOfNode(l1) + getValueOfNode(l2) + inc;
            ListNode node = new ListNode(sum % 10);
            if (current == null) {
                result = node;
                current = result;
            } else {
                current.next = node;
                current = current.next;
            }
            inc = sum / 10;
            l1 = moveForward(l1);
            l2 = moveForward(l2);

        }

        if (inc > 0) {
            current.next = new ListNode(1);
        }

        return result;
    }

    private int getValueOfNode(ListNode node) {
        return node == null ? 0 : node.val;
    }

    private ListNode moveForward(ListNode node) {
        return (node == null) ? null : node.next;
    }
}
