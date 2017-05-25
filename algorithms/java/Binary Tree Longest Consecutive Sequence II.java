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
    HashMap<TreeNode, Integer> mapIncrease = new HashMap<>();
    HashMap<TreeNode, Integer> mapDecrease = new HashMap<>();
    int ret = 0;
    
    // the longest consecutive path from root to its children
    private int longestConsecutiveHelper(TreeNode root, HashMap<TreeNode, Integer> map, int sign) {
        if(root == null) {
            return 0;
        }
        
        if(map.containsKey(root)) {
            return map.get(root);
        }

        int len = 1;
        if(root.left != null) {
            map.put(root.left, longestConsecutiveHelper(root.left, map, sign));
            if(root.left.val == root.val + sign) {
                len = Math.max(len, 1 + map.get(root.left));
            }
        }
        if(root.right != null) {
            map.put(root.right, longestConsecutiveHelper(root.right, map, sign));
            if(root.right.val == root.val + sign) {
                len = Math.max(len, 1 + map.get(root.right));
            }
        }
        
        map.put(root, len);
        return len;
    }
    
    private void dfs(TreeNode root) {
        if(root == null) {
            return ;
        }
        
        if(mapIncrease.containsKey(root) && mapDecrease.containsKey(root)) {
            ret = Math.max(ret, mapIncrease.get(root) + mapDecrease.get(root) - 1);
        } else if(mapIncrease.containsKey(root)) {
            ret = Math.max(ret, mapIncrease.get(root));
        } else if(mapDecrease.containsKey(root)) {
            ret = Math.max(ret, mapDecrease.get(root));
        } else {
            ret = Math.max(ret, 1);
        }
        
        dfs(root.left);
        dfs(root.right);
    }
    
    public int longestConsecutive(TreeNode root) {
        longestConsecutiveHelper(root, mapIncrease, 1);
        longestConsecutiveHelper(root, mapDecrease, -1);
        
        dfs(root);
        return ret;
    }
}