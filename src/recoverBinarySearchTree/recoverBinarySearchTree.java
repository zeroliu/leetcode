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
    public void recoverTree(TreeNode root) {
        HashMap<String, TreeNode> map = new HashMap<String, TreeNode>();
        recoverTreeHelper(root, map);
        int tmp = map.get("e1").val;
        map.get("e1").val = map.get("e2").val;
        map.get("e2").val = tmp;
    }
    
    void recoverTreeHelper(TreeNode root, HashMap<String, TreeNode> map) {
        if (root == null) {
            return;
        }
        
        recoverTreeHelper(root.left, map);
        if (map.containsKey("prev")) {
            if (map.get("prev").val > root.val) {
                if (map.containsKey("e1")) {
                    map.put("e2", root);
                } else {
                    map.put("e1", map.get("prev"));
                    map.put("e2", root);
                }
            }
        }
        map.put("prev", root);
        recoverTreeHelper(root.right, map);
    }
}
