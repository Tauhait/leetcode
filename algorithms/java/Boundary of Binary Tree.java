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
    ArrayList<TreeNode> levs = new ArrayList<>();
    
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left == null && root.right == null) {
            levs.add(root);
        }
        
        if(root.left != null) {
            dfs(root.left);
        }
        if(root.right != null) {
            dfs(root.right);
        }
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        
        //left
        TreeNode p = root;
        ArrayList<TreeNode> left = new ArrayList<>();
        left.add(root);
        if(p.left != null) {
            p = p.left;
            while(p != null) {
                left.add(p);
                if(p.left != null) { 
                    p = p.left;
                } else if(p.right != null) {
                    p = p.right;
                } else break;
            }
        }

        dfs(root);
        
        // right
        p = root;
        ArrayList<TreeNode> right = new ArrayList<>();
        if(p.right != null) {
            p = p.right;
            while(p != null) {
                right.add(p);
                if(p.right != null) {
                 p = p.right;
                } else if(p.left != null) {
                    p = p.left;
             } else break;
            }
        }
        
        HashSet<TreeNode> set = new HashSet<>();
        for(TreeNode num: left) {
            res.add(num.val);
            set.add(num);
        }
        
        for(TreeNode num: levs) {
            if(!set.contains(num)) {
                res.add(num.val);
                set.add(num);
            }   
        }
        int size = right.size();
        for(int i = size - 1;i >= 0;--i) {
            TreeNode num = right.get(i);
            if(!set.contains(num)) {
                res.add(num.val);
                set.add(num);
            }
        }
        
        return res;
    }
}