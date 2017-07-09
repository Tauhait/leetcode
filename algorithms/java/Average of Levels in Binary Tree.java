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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int s = q.size();
            double sum = 0;
            for(int i = 0;i < s;++i) {
                TreeNode f = q.poll();
                sum += (double) f.val;
                if(f.left != null) q.add(f.left);
                if(f.right != null) q.add(f.right);
            }
            ret.add((double) sum / (double) s);
        }
        return ret;      
    }
}