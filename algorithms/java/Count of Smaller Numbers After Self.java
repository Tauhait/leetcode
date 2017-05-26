public class Solution {
    private class TreeNode {
        int val;
        int numOfEqual;
        int numOfNodeInLeftTree;
        
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val, int numOfEqual, int numOfNodeInLeftTree, TreeNode left, TreeNode right) {
            this.val = val;
            this.numOfEqual = numOfEqual;
            this.numOfNodeInLeftTree = numOfNodeInLeftTree;
            
            this.left = left;
            this.right = right;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ret = new ArrayList<>();
        if(n == 0) {
            return ret;
        }
        
        ret.add(0);
        TreeNode root = new TreeNode(nums[n - 1], 1, 0, null, null);
        for(int i = n - 2;i >= 0;--i) {
            TreeNode p = root;
            int numOfSmaller = 0;
            while(p != null) {
                if(p.val == nums[i]) {
                    numOfSmaller += p.numOfNodeInLeftTree;
                    ret.add(numOfSmaller);
                    p.numOfEqual++;
                    break;
                } else if(p.val > nums[i]) {
                    if(p.left == null) {
                        p.left = new TreeNode(nums[i], 1, 0, null, null);
                        p.numOfNodeInLeftTree++;
                        ret.add(numOfSmaller);
                        break;
                    } else {
                        p.numOfNodeInLeftTree++;
                        p = p.left;
                    }
                } else {
                    if(p.right == null) {
                        p.right = new TreeNode(nums[i], 1, 0, null, null);
                        numOfSmaller += p.numOfEqual + p.numOfNodeInLeftTree;
                        ret.add(numOfSmaller);
                        break;
                    } else {
                        numOfSmaller += p.numOfEqual + p.numOfNodeInLeftTree;
                        p = p.right;
                    }
                }
            }
        }
        
        Collections.reverse(ret);
        return ret;
    }
}