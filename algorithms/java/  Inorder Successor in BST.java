/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        
        if(p.right != null) {
            TreeNode q = p.right;
            while(q.left != null) q = q.left;
            return q;
        }
        
        TreeNode successor = null, q = root;
        while(q != null) {
            if(q == p) return successor;
            else if(p.val > q.val) {
                q = q.right;
            } else {
                successor = q;
                q = q.left;
            }
        }
        return successor;
    }
}