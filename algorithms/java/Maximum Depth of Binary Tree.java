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
    private class Pair {
        public Pair(int _depth, TreeNode _node) {
            depth = _depth;
            node = _node;
        }
        
        int depth;
        TreeNode node;
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, root));
        while(!queue.isEmpty()) {
            Pair front = queue.poll();
            res = Math.max(front.depth, res);
            if(front.node.left != null) {
                queue.add(new Pair(front.depth + 1 ,front.node.left));
            }
            if(front.node.right != null) {
                queue.add(new Pair(front.depth + 1, front.node.right));
            }
        }
        
        return res;
    }
}