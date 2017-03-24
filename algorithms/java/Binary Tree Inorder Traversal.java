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
        Pair(TreeNode _node, int _id) {
            node = _node;
            id = _id;
        }
        
        TreeNode node;
        int id;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        /*
        if(root.left != null) {
            res.addAll(inorderTraversal(root.left));    
        }
        res.add(root.val);
        if(root.right != null) {
            res.addAll(inorderTraversal(root.right));
        }
        */
        
        // without recursion
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while(!stack.empty()) {
            Pair top = stack.pop();
            if(top.node.left != null && top.id == 1) {
                stack.push(new Pair(top.node, 2));
                stack.push(new Pair(top.node.left, 1));
            } else {
                res.add(top.node.val);
                if(top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
            }
        }
        
        return res;
    }
}