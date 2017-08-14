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
    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if(l > r) return null;
        if(l == r) return new TreeNode(nums[l]);
        
        int index = l;
        int maxValue = nums[l];
        for(int i = l + 1;i <= r;++i) {
            if(nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructMaximumBinaryTree(nums, l, index - 1);
        node.right = constructMaximumBinaryTree(nums, index + 1, r);
        return node;      
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);        
    }
}