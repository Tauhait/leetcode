/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int dfs(TreeNode root) { // take root node
        if(root == null) return 0;
        
        int val = root.val;
        if(root.left != null ) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        
        return val;                                  
    }
    
    public int rob(TreeNode root) {
        if(root == null) return 0;
        return Math.max(dfs(root), rob(root.left) + rob(root.right));
    }
}