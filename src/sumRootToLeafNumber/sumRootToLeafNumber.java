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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        calculate(root, 0);
        return sum;
    }
    
    void calculate(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        current = current*10 + root.val;
        if (root.left == null && root.right == null) {
            sum += current;
        }
        calculate(root.left, current);
        calculate(root.right, current);
    }
}
