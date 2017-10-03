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
    Map<TreeNode, Integer> map = new HashMap<>();
    
    /** the longest path start from root and have same value as root */
    private int longestUnivaluePathHelper(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        
        int len = 1;
        if(root.left != null && root.left.val == root.val) len = Math.max(len, longestUnivaluePathHelper(root.left) + 1);
        if(root.right != null && root.right.val == root.val) len = Math.max(len, longestUnivaluePathHelper(root.right) + 1);
        
        map.put(root, len);
        return len;
    }
    
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        
        int maxLen = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        
        int s = 0;
        if(root.left != null && root.left.val == root.val) {
            s += longestUnivaluePathHelper(root.left);
        }
        if(root.right != null && root.right.val == root.val) {
            s += longestUnivaluePathHelper(root.right);
        }
        return Math.max(s, maxLen);
    }
}