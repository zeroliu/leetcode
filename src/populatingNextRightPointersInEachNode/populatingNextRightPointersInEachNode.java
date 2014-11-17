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
        root.next = null;
        while (root != null) {
            TreeLinkNode current = root;
            while (current != null) {
                TreeLinkNode a = current.left;
                TreeLinkNode b = current.right;
                if (a == null) break;
                a.next = b;
                if (current.next != null) {
                    b.next = current.next.left;
                } else {
                    b.next = null;
                }
                current = current.next;
            }
            root = root.left;
        }
    }
}
