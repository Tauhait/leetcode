class Solution {
	public int networkDelayTime(int[][] times, int N, int K) {
		long[][] adj = new long[N + 1][N + 1];
		for (int i = 0; i <= N; ++i) Arrays.fill(adj[i], Integer.MAX_VALUE);
		for (int i = 0; i < times.length; ++i) {
			int u = times[i][0];
			int v = times[i][1];
			int w = times[i][2];
			adj[u][v] = w;
		}

		long[] dis = new long[N + 1];
		for (int i = 1; i <= N; ++i) dis[i] = adj[K][i];

		boolean[] visited = new boolean[N + 1];
		visited[K] = true;
		dis[K] = 0;

		for (int i = 1; i <= N; ++i) {
			long minDis = Integer.MAX_VALUE;
			int id = -1;
			for (int j = 1; j <= N; ++j) {
				if (visited[j] == false && dis[j] < minDis) {
					minDis = dis[j];
					id = j;
				}
			}

			if (id == -1) break;
			visited[id] = true;
			for (int j = 1; j <= N; ++j) {
				if (visited[j] == false && dis[id] + adj[id][j] < dis[j]) {
					dis[j] = dis[id] + adj[id][j];
				}
			}
		}

		long maxDis = -1;
		for (int i = 1; i <= N; ++i)
			maxDis = Math.max(maxDis, dis[i]);

		if (maxDis == Integer.MAX_VALUE) return -1;
		return (int) maxDis;
	}
}