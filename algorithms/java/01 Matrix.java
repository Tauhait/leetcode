
public class Solution {
	private class Pair {
		int r;
		int c;
		int d;

		public Pair(int _r, int _c, int _d) {
			r = _r;
			c = _c;
			d = _d;
		}
	}

	int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
		List<List<Integer>> res = new ArrayList<>();
		int m = matrix.size();
		if (m == 0) {
			return res;
		}
		int n = matrix.get(0).size();
		if (n == 0) {
			return res;
		}

		int[][] ans = new int[m][n];
		for (int i = 0; i < m; ++i) {
			Arrays.fill(ans[i], Integer.MAX_VALUE);
		}
        
        	// put all 0 at frist, then 1s, and so on
        	Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix.get(i).get(j) == 0) {
				    q.add(new Pair(i, j, 0));
				    ans[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
		    Pair front = q.poll();
			for (int i = 0; i < 4; ++i) {
			    int r = front.r + dir[i][0];
				int c = front.c + dir[i][1];
				if (r >= 0 && r < m && c >= 0 && c < n) {
				    int d = front.d + 1;
				    if(ans[r][c] > d) {
				        ans[r][c] = d;
				        q.add(new Pair(r, c, d));
				    }
				}
			}
		}
	
		for (int i = 0; i < m; ++i) {
			ArrayList<Integer> sol = new ArrayList<>();
			for (int j = 0; j < n; ++j) {
				sol.add(ans[i][j]);
			}
			res.add(sol);
		}
		return res;
	}
}
