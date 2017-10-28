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
            return "#";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(root.val));
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(",");
        sb.append(serialize(root.right));
        return sb.toString();
    }
    
    private TreeNode deserializeHelper(String[] d, int[] index) {
        if(index[0] >= d.length) {
            return null;
        }
        
        if(d[index[0]].equals("#")) {
            index[0]++;
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(d[index[0]]));
        index[0]++;
        root.left = deserializeHelper(d, index);
        root.right = deserializeHelper(d, index);
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] d = data.split(",");
        int[] index = new int[1];
        index[0] = 0;
        return deserializeHelper(d, index);
    }
}

/////////
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
        if(root == null) return "#";
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(serialize(root.left)).append(",");
        sb.append(serialize(root.right));
        
        return sb.toString();
    }
    
    private TreeNode deserializeHelper(Queue<String> q) {
        if(q.isEmpty()) return null;
        if(q.peek().equals("#")) {q.poll(); return null;}
    
        TreeNode root = new TreeNode(Integer.parseInt(q.poll()));
        root.left = deserializeHelper(q);
        root.right = deserializeHelper(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


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
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode f = q.poll();
            if(f != null) {
                sb.append(f.val);
                sb.append(",");
                q.add(f.left);
                q.add(f.right);
            } else {
                sb.append("#,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        
        String[] d = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(d[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while(i < d.length) {
            TreeNode f = q.poll();
            if(d[i].charAt(0) == '#') {
                f.left = null;
            } else {
                f.left = new TreeNode(Integer.parseInt(d[i]));
                q.add(f.left);
            }
            i++;
            
            if(d[i].charAt(0) == '#') {
                f.right = null;
            } else {
                f.right = new TreeNode(Integer.parseInt(d[i]));
                q.add(f.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));