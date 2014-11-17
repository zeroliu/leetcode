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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (root == null) { return results; }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> buffer = new LinkedList<TreeNode>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        queue.add(root);
        
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                buffer.add(node.left);
            }
            if (node.right != null) {
                buffer.add(node.right);
            }
            if (queue.size() == 0) {
                ((LinkedList<List<Integer>>)results).addFirst(result);
                result = new LinkedList<Integer>();
                queue = buffer;
                buffer = new LinkedList<TreeNode>();
            }
        }
        return results;
    }
}
