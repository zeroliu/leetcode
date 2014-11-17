/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        while (root != null) {
            TreeLinkNode current = root;
            TreeLinkNode prev = null;
            TreeLinkNode next = null;
            TreeLinkNode first = null;
            while (current != null) {
                while (prev == null) {
                    if (current == null) break;
                    prev = current.left;
                    if (prev == null) {
                        prev = current.right;
                        current = current.next;
                    }
                }
                if (first == null) { first = prev; }
                if (prev == null) continue;
                while (next == null || next == prev) {
                    if (current == null) break;
                    next = current.left;
                    if (next == null || next == prev) {
                        next = current.right;
                        current = current.next;
                    }
                }
                prev.next = next;
                prev = next;
                next = null;
            }
            root = first;
        }
        
    }
}
