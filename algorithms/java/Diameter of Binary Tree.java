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
    Map<TreeNode, Integer> deepMap = new HashMap<>();
    
    private int getDeep(TreeNode root) {
        if(root == null) return 0;
        if(deepMap.containsKey(root)) return deepMap.get(root);
        
        int d = 1 + Math.max(getDeep(root.left), getDeep(root.right));
        deepMap.put(root, d);
        return d;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int diameter = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(diameter, getDeep(root.left) + getDeep(root.right));
    }
}