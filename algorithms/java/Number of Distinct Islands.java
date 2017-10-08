class Solution {
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private void dfs(int r, int c, int m, int n, boolean[][] visited, 
                     int[][] grid, List<int[]> points, Set<List<Long> > set) {
        points.add(new int[]{r, c});
        for (int d = 0; d < 4; ++d) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                visited[nr][nc] == false && grid[nr][nc] == 1) {
                visited[nr][nc] = true;
                dfs(nr, nc, m, n, visited, grid, points, set);
            }
        }
    }

    private void encode(List<int[]> points, Set<List<Long> > set) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        for (int[] point: points) {
            minR = Math.min(minR, point[0]);
            minC = Math.min(minC, point[1]);
        }

        Collections.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<Long> codes = new ArrayList<>();
        for (int[] point: points) {
            long nr = point[0] - minR;
            long nc = point[1] - minC;
            codes.add((nr << 32) + nc);
        }
        set.add(codes);
    }

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if(m == 0 || n == 0) return 0;
        
        Set<List<Long> > set = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (visited[i][j] == false && grid[i][j] == 1) {
                    List<int[]> points = new ArrayList<>();
                    visited[i][j] = true;
                    dfs(i, j, m, n, visited, grid, points, set);
                    encode(points, set);
                }
            }
        }
        return set.size();
    }
}