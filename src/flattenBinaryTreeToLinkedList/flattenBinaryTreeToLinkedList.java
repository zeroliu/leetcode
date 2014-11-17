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
    public void flatten(TreeNode root) {
        if (root == null) { return; }
        flatten(root.left);
        TreeNode end = root.left;
        if (end != null) {
            while (end.right != null) {
                end = end.right;
            }
        }
        flatten(root.right);
        if (root.left != null) {
            end.right = root.right;
            root.right = root.left;
        }
        root.left = null;
    }
}
