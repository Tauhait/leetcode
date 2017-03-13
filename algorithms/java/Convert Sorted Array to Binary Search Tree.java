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
    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if(l > r) return null;
        TreeNode root = new TreeNode(-1);
        if(l == r) {
            root.left = null;
            root.right = null;
            root.val = nums[l];
            return root;
        }
      
        int m = l + (r - l + 1) / 2;
        System.out.println(m + " " + l + " " + r);
        if((r - l + 1) % 2 != 1) {
            m--;
        } 
        root.val = nums[m];
        root.left = sortedArrayToBST(nums, l, m - 1);
        root.right = sortedArrayToBST(nums, m + 1, r);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}