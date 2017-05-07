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
    
    private boolean sameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        
        if(s.val != t.val) {
            return false;
        }
        
        if(sameTree(s.left, t.left) && sameTree(s.right, t.right)) {
            return true;
        }
        
        return false;
    }
    
    
    private boolean dfs(TreeNode s, TreeNode t) {
        if(s.val == t.val) {
            if(sameTree(s, t)) {
                return true;
            }
        }
        
        if(s.left != null) {
            if(dfs(s.left, t)) return true;
        }
        if(s.right != null) {
            if(dfs(s.right, t)) return true;
        }
        
        return false;
    } 
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(t == null) {
            return true;
        }
        if(s == null && t != null) {
            return false;
        }
        
        return dfs(s, t);
    }
}