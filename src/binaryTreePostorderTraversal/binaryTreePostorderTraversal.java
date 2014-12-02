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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new LinkedList<Integer>();
        if (root == null) { return results; }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while (stack.size() > 0) {
            TreeNode node = stack.poll();
            ((LinkedList<Integer>)results).addFirst(node.val);
            if (node.left != null) {
                stack.addFirst(node.left);
            }
            if (node.right != null) {
                stack.addFirst(node.right);
            }
        }
        return results;
    }
}