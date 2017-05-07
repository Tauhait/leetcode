public class Solution {
	private int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	private int[][][] opt;

	private int MOD = 1000000007;

	private int dfs(int r, int c, int K, int m, int n) {
		if (K < 0) {
			return 0;
		}
		if (opt[r][c][K] != -1) {
			return opt[r][c][K];
		}

		int s = 0;
		for (int i = 0; i < 4; ++i) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];

			if (nr > 0 && nr < m - 1 && nc > 0 && nc < n - 1) {
				s += dfs(nr, nc, K - 1, m, n);
				s %= MOD;
			}
		}

		opt[r][c][K] = s % MOD;
		return opt[r][c][K];
	}

	public int findPaths(int m, int n, int N, int I, int J) {
		m = m + 2;
		n = n + 2;
		I = I + 1;
		J = J + 1;
		opt = new int[m][n][N + 1];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				Arrays.fill(opt[i][j], -1);
				opt[i][j][0] = 0;
			}
		}
		opt[I][J][0] = 1;

		for (int k = 1; k <= N; ++k) {
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					dfs(i, j, k, m, n);
				}
			}
		}

		int ret = 0;
		for (int i = 0; i < m; ++i) {
			for (int k = 0; k <= N; ++k) {
				ret += opt[i][0][k];
				ret %= MOD;

				ret += opt[i][n - 1][k];
				ret %= MOD;
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int k = 0; k <= N; ++k) {
				ret += opt[0][i][k];
				ret %= MOD;

				ret += opt[m - 1][i][k];
				ret %= MOD;
			}
		}

		return ret;
	}
}
