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
    private int c;
    private int res;
    private boolean found = false;
    private void inorderTraverse(TreeNode root, int k) {
        if(found) return ;
        
        if(root == null) return ;
        
        inorderTraverse(root.left, k);
        
        if(c == k && found == false) {
            res = root.val;
            found = true;
            return ;
        }
        c++;

        inorderTraverse(root.right, k);
    }
    
    public int kthSmallest(TreeNode root, int k) {
        c = 1;
        inorderTraverse(root, k);
        return res;
    }
}