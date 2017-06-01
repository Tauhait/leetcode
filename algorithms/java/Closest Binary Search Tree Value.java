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
    public int closestValue(TreeNode root, double target) {
        double minDis = Double.MAX_VALUE;
        
        TreeNode p = root;
        int ret = 0;
        while(p != null) {
            if(Math.abs(p.val - target) < minDis) {
                ret = p.val;
                minDis = Math.abs(p.val - target);
            }
            
            if(p.val > target) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return ret;
    }
}