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
    private int maxSum(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        
        int childSum = Math.max(maxSum(root.left, map), maxSum(root.right, map));
        int sum = root.val;
        if(childSum > 0) sum += childSum;
        map.put(root, sum);
        return sum;
    }
    
    private int findMaxPathSum(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null) return 0;
        
        int l = 0, r = 0;
        if(root.left != null) l = map.get(root.left);
        if(root.right != null) r = map.get(root.right);
        
        int max = Integer.MIN_VALUE;
        max = Math.max(max, root.val);
        max = Math.max(max, l + root.val);
        max = Math.max(max, r + root.val);
        max = Math.max(max, l + root.val + r);
        
        if(root.left != null) max = Math.max(max, findMaxPathSum(root.left, map));
        if(root.right != null) max = Math.max(max, findMaxPathSum(root.right, map));
        return max;
    }
    
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        // the maximum path sum start from the node to it subtree
        Map<TreeNode, Integer> map = new HashMap<>();
        maxSum(root, map);
        
        return findMaxPathSum(root, map);
    }
}