class Solution {
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int dfs(int r, int c, int m, int n, boolean[][] visited, int[][] grid) {
        int count = 1;
        for(int d = 0;d < 4;++d) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n &&
               visited[nr][nc] == false && grid[nr][nc] == 1) {
                visited[nr][nc] = true;
                count += dfs(nr, nc, m, n, visited, grid);
            }
        }
        return count;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if(m == 0 || n == 0) return 0;
        
        int ret = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(visited[i][j] == false && grid[i][j] == 1) {
                    visited[i][j] = true;
                    ret = Math.max(ret, dfs(i, j, m, n, visited, grid));
                }    
            }
        }
        return ret;
    }
}