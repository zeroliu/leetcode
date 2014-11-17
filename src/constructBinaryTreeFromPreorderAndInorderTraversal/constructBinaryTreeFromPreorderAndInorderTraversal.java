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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = preorder.length;
        if (l == 0) {
            return null;
        }
        return buildTree(preorder, 0, l-1, inorder, 0, l-1);
    }
    
    TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (is > ie) {
            return null;
        }
        int val = preorder[ps];
        TreeNode root = new TreeNode(val);
        int index = is;
        for (int i=is; i<=ie; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = buildTree(preorder, ps+1, ps+index-is, inorder, is, index-1);
        root.right = buildTree(preorder, ps+index-is+1, pe, inorder, index+1, ie);
        return root;
    }
}
