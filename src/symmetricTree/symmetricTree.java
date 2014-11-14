/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        return isMirrorIter(root.left, root.right);
    }
    
    boolean isMirrorRecursive(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        if (!isMirrorRecursive(left.left, right.right)) {
            return false;
        }
        if (!isMirrorRecursive(left.right, right.left)) {
            return false;
        }
        return true;
    }
    
    boolean isMirrorIter(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        
        LinkedList<TreeNode> stackL = new LinkedList<TreeNode>();
        LinkedList<TreeNode> stackR = new LinkedList<TreeNode>();
        stackL.add(left);
        stackR.add(right);
        
        while (stackL.size() > 0 && stackR.size() > 0) {
            TreeNode l = stackL.poll();
            TreeNode r = stackR.poll();
            if (l.val != r.val) {
                return false;
            }
            if (l.left != null && r.right != null) {
                stackL.addFirst(l.left);
                stackR.addFirst(r.right);
            } else if (l.left != null || r.right != null) {
                return false;
            }
            if (r.left != null && l.right != null) {
                stackL.addFirst(r.left);
                stackR.addFirst(l.right);
            } else if (r.left != null || l.right != null) {
                return false;
            }
        }
        
        return true;
    }
}
