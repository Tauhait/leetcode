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
    List<List<String>> ret = new ArrayList<>();
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(dfs(root.left), dfs(root.right));
    }

    private void dfs(TreeNode root, int lev, int rootPos, int l, int r) {
        if (root == null) return;

        if (root.left != null) {
            int len = rootPos - l;
            int pos = l + len / 2;
            ret.get(lev + 1).set(pos, String.valueOf(root.left.val));
            dfs(root.left, lev + 1, pos, l, rootPos - 1);
            dfs(root.left, lev + 1, pos, l, rootPos - 1);
        }

        if (root.right != null) {
            int len = r - rootPos;
            int pos = rootPos + len / 2 + 1;
            ret.get(lev + 1).set(pos, String.valueOf(root.right.val));
            dfs(root.right, lev + 1, pos, rootPos + 1, r);
            dfs(root.right, lev + 1, pos, rootPos + 1, r);
        }

    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return ret;
        int m = dfs(root);
        int n = (1 << m) - 1;

        for (int i = 0; i < m; ++i) {
            ret.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ret.get(i).add(j, "");
            }
        }

        ret.get(0).set(n / 2, String.valueOf(root.val));
        dfs(root, 0, n / 2, 0, n - 1);

        return ret;
    }
}
