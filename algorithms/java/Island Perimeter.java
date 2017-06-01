public class Solution {
    int m;
    int n;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int neighbors(int r, int c, int[][] grid) {
        int count = 0;
        for(int d = 0;d < 4;++d) {
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                count++;
            }
        }
        return count;
    }
    
    public int islandPerimeter(int[][] grid) {
        m = grid.length;
        if(m == 0) {
            return 0;
        }
        n = grid[0].length;
        if(n == 0) {
            return 0;
        }
        int r = -1, c = -1;
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(grid[i][j] == 1) {
                    r = i;
                    c = j;
                }
            }
        }
        if(r == -1 || c == -1) {
            return 0;
        }
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        visited[r][c] = true;
        int ret = 4 - neighbors(r, c, grid);
        while(!q.isEmpty()) {
            int[] f = q.poll();
            for(int d = 0;d < 4;++d) {
                int nr = f[0] + dir[d][0];
                int nc = f[1] + dir[d][1];
                
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && visited[nr][nc] == false) {
                    ret += 4 - neighbors(nr, nc, grid);
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return ret;
    }
}