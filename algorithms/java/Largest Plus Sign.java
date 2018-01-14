class Solution {
	private int[][] getLeft(int N, int[][] grid) {
		int[][] count = new int[N][N];
		for (int i = 0; i < N; ++i) {
			count[i][0] = 0;
			for (int j = 1; j < N; ++j)
				count[i][j] = grid[i][j - 1] == 1 ? count[i][j - 1] + 1 : 0;
		}
		return count;
	}

	private int[][] getRight(int N, int[][] grid) {
		int[][] count = new int[N][N];
		for (int i = 0; i < N; ++i) {
			count[i][N - 1] = 0;
			for (int j = N - 2; j >= 0; --j)
				count[i][j] = grid[i][j + 1] == 1 ? count[i][j + 1] + 1 : 0;
		}
		return count;
	}

	private int[][] getUp(int N, int[][] grid) {
		int[][] count = new int[N][N];
		for (int j = 0; j < N; ++j) {
			count[0][j] = 0;
			for (int i = 1; i < N; ++i)
				count[i][j] = grid[i - 1][j] == 1 ? count[i - 1][j] + 1 : 0;
		}
		return count;
	}

	private int[][] getDown(int N, int[][] grid) {
		int[][] count = new int[N][N];
		for (int j = 0; j < N; ++j) {
			count[N - 1][j] = 0;
			for (int i = N - 2; i >= 0; --i)
				count[i][j] = grid[i + 1][j] == 1 ? count[i + 1][j] + 1 : 0;
		}
		return count;
	}

	private int getMin(int a, int b, int c, int d) {
		return Math.min(Math.min(a, b), Math.min(c, d));
	}

	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int[][] grid = new int[N][N];
		for (int i = 0; i < N; ++i)
			Arrays.fill(grid[i], 1);
		for (int i = 0; i < mines.length; ++i)
			grid[mines[i][0]][mines[i][1]] = 0;

		int[][] left = getLeft(N, grid);
		int[][] right = getRight(N, grid);
		int[][] up = getUp(N, grid);
		int[][] down = getDown(N, grid);

		int ret = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (grid[i][j] == 1) {
					ret = Math.max(ret, getMin(left[i][j], right[i][j], up[i][j], down[i][j]) + 1);
				}
			}
		}
		return ret;
	}
}