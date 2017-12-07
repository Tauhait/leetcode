// proces right, left and root, keep the previous processed node
class Solution {
    private TreeNode pre = null;
    
    public void flatten(TreeNode root) {
        if(root == null) return ;
        
        flatten(root.right);
        flatten(root.left);
        
        if(pre != null) {
            root.right = pre;
            root.left = null;
        }
        pre = root;
    }
}


////// return last node the the link list
class Solution {
    private TreeNode flattenHelper(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;
        
        TreeNode leftLast = flattenHelper(root.left);
        TreeNode rightLast = flattenHelper(root.right);
        
        TreeNode left = root.left, right = root.right;
        
        if(root.left != null && root.right != null) {
            root.left = null;
            root.right = left;
            leftLast.right = right;
            return rightLast;
        } else if(root.left == null && root.right != null) {
            root.left = null;
            root.right = right;
            return rightLast;
        } else { // root.left != null && root.right == null
            root.left = null;
            root.right = left;
            return leftLast;
        }
    }
    
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
}