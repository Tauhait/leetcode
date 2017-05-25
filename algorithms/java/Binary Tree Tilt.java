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
    private int tilt = 0;
    
    int sumOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null) {
            return root.val;
        }
        
        int leftSum = 0;
        int rightSum = 0;
        if(root.left != null) {
            leftSum = sumOfTree(root.left);
        }
        if(root.right != null) {
            rightSum = sumOfTree(root.right);
        }
        
        tilt += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
    
    public int findTilt(TreeNode root) {
        sumOfTree(root);
        return tilt;
    }
}