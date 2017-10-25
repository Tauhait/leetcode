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




//////////   O(h) space, h is the height of the tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;

        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        
        TreeNode p = root;
        while(p.left != null) {
            left.push(p);
            p = p.left;
        }
        left.push(p);
        
        p = root;
        while(p.right != null) {
            right.push(p);
            p = p.right;
        }
        right.push(p);
        
        while(!left.empty() && !right.empty() && left.peek() != right.peek()) {
            int s = left.peek().val + right.peek().val;
            if(s == k) return true;
            
            if(s > k) {
                TreeNode q = right.pop();
                if(q.left != null) {
                    q = q.left;
                    while(q.right != null) {
                        right.push(q);
                        q = q.right;
                    }
                    right.push(q);
                }
            } else {
                TreeNode q = left.pop();
                if(q.right != null) {
                    q = q.right;
                    while(q.left != null) {
                        left.push(q);
                        q = q.left;
                    }
                    left.push(q);
                }
            }
        }
        return false;
    }
}