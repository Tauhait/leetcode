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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        if(root.left != null && !isValidBST(root.left)) {
            return false;
        }
        if(root.right != null && !isValidBST(root.right)) {
            return false;
        }
        
        if(root.left != null) {
            TreeNode p = root.left;
            while(p.right != null) {
                p = p.right;
            }
            if(root.val <= p.val) {
                return false;
            }
        }
        if(root.right != null) {
            TreeNode p = root.right;
            while(p.left != null) {
                p = p.left;
            }
            if(root.val >= p.val) {
                return false;
            }
        }
        return true;
    }
}

///////////////////////////////////////////////
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
    private boolean isValidBSTHelper(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        if(root == null) {
            return true;
        }
        
        if(minNode != null && root.val <= minNode.val) {
            return false;
        }    
        if(maxNode != null && root.val >= maxNode.val) {
            return false;
        }
        
        if(root.left != null && !isValidBSTHelper(root.left, minNode, root)) {
            return false;
        }
        if(root.right != null && !isValidBSTHelper(root.right, root, maxNode)) {
            return false;
        }
        return true;
    }
        
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
}