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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> results = new LinkedList<List<Integer>>();
        if (root == null) {
            return results;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> buffer = new LinkedList<TreeNode>();
        List<Integer> current = new LinkedList<Integer>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode n = queue.pop();
            current.add(n.val);
            if (n.left != null) {
                buffer.add(n.left);
            }
            if (n.right != null) {
                buffer.add(n.right);
            }
            if (queue.size() == 0) {
                queue = buffer;
                buffer = new LinkedList<TreeNode>();
                results.add(current);
                current = new LinkedList<Integer>();
            }
        }
        return results;
    }
}
