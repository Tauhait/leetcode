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
    Map<TreeNode, String> hash;
    private String serializeTree(TreeNode root) {
        if(root == null) {
            return "#";
        }
        if(hash.containsKey(root)) {
            return hash.get(root);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(root.val));
        sb.append(",");
        sb.append(serializeTree(root.left));
        sb.append(",");
        sb.append(serializeTree(root.right));
        String s = sb.toString();
        hash.put(root, s);
        return s;
    }

    Map<String, List<TreeNode> > serializeMap;
    
    private void dfs(TreeNode root) {
        if(root == null) {
            return ;
        }

        String s = serializeTree(root);
        if(!serializeMap.containsKey(s)) {
            serializeMap.put(s, new ArrayList<>());
        }
        serializeMap.get(s).add(root);
        
        dfs(root.left);
        dfs(root.right);
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hash = new HashMap<>();
        serializeMap = new HashMap<>();
        dfs(root);
        
        List<TreeNode> ret = new ArrayList<>();
        for(Map.Entry<String, List<TreeNode> > entry: serializeMap.entrySet()) {
            if(entry.getValue().size() > 1) {
                ret.add(entry.getValue().get(0));
            }
        }
        return ret;
    }
}