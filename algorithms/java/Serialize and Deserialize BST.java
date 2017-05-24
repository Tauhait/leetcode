/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return ",";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    
    private TreeNode deserialize(String[] d, int[] index) {
        if(index[0] == d.length) {
            return null;
        }
        if(d[index[0]].length() == 0) {
            index[0]++;
            return null;
        }
        
        
        TreeNode root = new TreeNode(Integer.parseInt(d[index[0]]));
        index[0]++;
        
        root.left = deserialize(d, index);
        root.right = deserialize(d, index);
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        int[] index =  new int[1];
        index[0] = 0;
        return deserialize(d, index);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));