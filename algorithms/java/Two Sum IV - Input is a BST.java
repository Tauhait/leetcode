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
    private ArrayList<Integer> arr = new ArrayList<>();
    
    private void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        arr.add(root.val);
        dfs(root.right);
    }
    
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        
        int l = 0, r = arr.size() - 1;
        while(l < r) {
            int s = arr.get(l) + arr.get(r);
            if(s == k) return true;
            else if(s > k) r--;
            else l++;
        }
        return false;       
    }
}