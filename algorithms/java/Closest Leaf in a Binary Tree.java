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
	private class Pair {
		int dis;
		TreeNode node;

		public Pair(int dis, TreeNode node) {
			this.dis = dis;
			this.node = node;
		}
	}

	Map<TreeNode, Pair> map = new HashMap<>();
	List<TreeNode> pathToK;

	private Pair cloestToLeaf(TreeNode root) {
		if (root == null) throw new RuntimeException("NO");
		if (root.left == null && root.right == null) {
			Pair pair = new Pair(0, root);
			map.put(root, pair);
			return pair;
		} else {
			Pair pairLeft = null, pairRight = null, ret = null;
			if (root.left != null) pairLeft = cloestToLeaf(root.left);
			if (root.right != null) pairRight = cloestToLeaf(root.right);

			if (pairLeft != null && pairRight != null) {
				if (pairLeft.dis < pairRight.dis) {
					ret = new Pair(pairLeft.dis + 1, pairLeft.node);
				} else {
					ret = new Pair(pairRight.dis + 1, pairRight.node);
				}
			} else if (pairLeft != null) {
				ret = new Pair(pairLeft.dis + 1, pairLeft.node);
			} else {
				ret = new Pair(pairRight.dis + 1, pairRight.node);
			}
			map.put(root, ret);
			return ret;
		}
	}

	private void dfs(TreeNode root, List<TreeNode> path, int k) {
		if (root == null) return;
		if (root.val == k) {
			pathToK = new ArrayList<>(path);
			return;
		}

		if (root.left != null) {
			path.add(root.left);
			dfs(root.left, path, k);
			path.remove(path.size() - 1);
		}
		if (root.right != null) {
			path.add(root.right);
			dfs(root.right, path, k);
			path.remove(path.size() - 1);
		}
	}

	public int findClosestLeaf(TreeNode root, int k) {
		if (root == null) return 0;
		cloestToLeaf(root);
		if (root.val == k) return map.get(root).node.val;
		List<TreeNode> path = new ArrayList<>();
		path.add(root);
		dfs(root, path, k);

		int len = pathToK.size();
		Pair minNode = null;
		for (int i = 0; i < pathToK.size(); ++i) {
			len--;
			TreeNode node = pathToK.get(i);
			if (node.val == k) {
				if (minNode == null || minNode.dis > map.get(node).dis) minNode = map.get(node);
			} else {
				if (node.left == pathToK.get(i + 1)) {
					if (node.right != null) {
						if (minNode == null || minNode.dis > map.get(node.right).dis + len + 1)
							minNode = new Pair(len + 1 + map.get(node.right).dis, map.get(node.right).node);
					}
				} else {
					if (node.left != null) {
						if (minNode == null || minNode.dis > map.get(node.left).dis + len + 1)
							minNode = new Pair(len + 1 + map.get(node.left).dis, map.get(node.left).node);
					}
				}
			}
		}
		return minNode.node.val;
	}
}