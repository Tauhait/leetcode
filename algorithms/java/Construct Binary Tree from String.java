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
    public TreeNode str2tree(String s) {
		if (s.length() == 0)
			return null;

		int pos = s.indexOf('(');
		if (pos == -1) {
			int val = Integer.valueOf(s);
			return new TreeNode(val);
		}
	
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(pos));
		int q = pos + 1;
		while (q < s.length()) {
			if (s.charAt(q) == ')') {
				if (!stack.empty())
					stack.pop();
			} else if (s.charAt(q) == '(') {
				stack.push(s.charAt(q));
			}
			q++;
			if (stack.empty())
				break;
		}

		TreeNode root = new TreeNode(-1);
		root.val = Integer.valueOf(s.substring(0, pos));
		root.left = str2tree(s.substring(pos + 1, q - 1));
		if (q + 1 < s.length()) {
			root.right = str2tree(s.substring(q + 1, s.length() - 1));
		}
	
		return root;
	}
}