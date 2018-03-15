class Solution {
    int minDis = Integer.MAX_VALUE;
    Integer preValue = null;
    
    private void preOrder(TreeNode root) {
        if(root == null) return ;
        preOrder(root.left);
        if(preValue != null) {
            minDis = Math.min(minDis, Math.abs(preValue.intValue() - root.val));
        }
        preValue = root.val;
        preOrder(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        preOrder(root);
        return minDis;
    }
}