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
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = null;
        ListNode current = head;
        if (lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override    
            public int compare(ListNode a, ListNode b) {
                if (a.val > b.val) {
                    return 1;
                }
                if (a.val < b.val) {
                    return -1;
                }
                return 0;
            }
        });
        
        //init heap with the first element of lists
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);    
            }
        }
        
        while (heap.size() > 0) {
            ListNode node = heap.poll();
            if (head == null) {
                head = node;
                current = head;
            } else {
                current.next = node;
                current = node;
            }
            if (node.next != null) {
                heap.add(node.next);
            }
        }
        
        return head;
    }
}
