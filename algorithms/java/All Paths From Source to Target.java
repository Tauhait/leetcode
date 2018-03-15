class Solution {
	private void dfs(int id, int[][] graph, List<Integer> cur, int n, List<List<Integer>> ret) {
		if (cur.size() > 0 && cur.get(cur.size() - 1) == n - 1) {
			ret.add(new ArrayList<>(cur));
            return;
		}
		for (int i = 0; i < graph[id].length; ++i) {
            cur.add(graph[id][i]);
			dfs(graph[id][i], graph, cur, n, ret);
            cur.remove(cur.size() - 1);
		}
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int n = graph.length;
		List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
		dfs(0, graph, cur, n, ret);
		return ret;
	}
}