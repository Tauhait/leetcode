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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer> > res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer> > map = new HashMap<>();

        qu.add(root);
        col.add(0);
        map.put(0, new ArrayList());
        map.get(0).add(root.val);
        int minVal = 0;
        int maxVal = 0;
        while(!qu.isEmpty()) {
            int s = qu.size();
            for(int i = 0;i < s;++i) {
                TreeNode t = qu.poll();
                int c = col.poll();
                
                if(t.left != null) {
                    qu.add(t.left);
                    col.add(c - 1);
                    if(!map.containsKey(c - 1)) {
                        map.put(c - 1, new ArrayList());
                    }
                    map.get(c - 1).add(t.left.val);
                    minVal = Math.min(minVal, c - 1);
                    maxVal = Math.max(maxVal, c - 1);
                }
                
                if(t.right != null) {
                    qu.add(t.right);
                    col.add(c + 1);
                    if(!map.containsKey(c + 1)) {
                        map.put(c + 1, new ArrayList());
                    }
                    map.get(c + 1).add(t.right.val);
                    minVal = Math.min(minVal, c + 1);
                    maxVal = Math.max(maxVal, c + 1);
                }
            }
        }
        
        for(int i = minVal;i <= maxVal;++i) {
            res.add(map.get(i));
        }
        return res;
    }
}