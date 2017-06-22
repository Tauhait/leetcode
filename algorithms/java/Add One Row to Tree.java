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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while(!q.isEmpty()) {
            if(depth == d - 1) {
                int s = q.size();
                for(int i = 0;i < s;++i) {
                    TreeNode f = q.poll();
                    TreeNode left = f.left;
                    TreeNode right = f.right;
                    f.left = new TreeNode(v);
                    f.right = new TreeNode(v);
                    f.left.left = left;
                    f.right.right = right;
                }
                return root;
            }
        
            int s = q.size();
            for(int i = 0;i < s;++i) {
                TreeNode f = q.poll();
                if(f.left != null) {
                    q.add(f.left);
                }
                if(f.right != null) {
                    q.add(f.right);
                }
            }
            depth++;
        }
        return root;
    }
}