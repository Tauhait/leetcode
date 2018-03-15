class Solution {
    private static final int[][] DIR = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    private class Point implements Comparable<Point> {
        int r;
        int c;
        int time;
        
        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
        
        public int compareTo(Point that) {
            return this.time - that.time;
        }
    }

    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if(m == 0 || n == 0) return 0;
        
        boolean[][] visited = new boolean[m][n];
        Queue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, grid[0][0]));
        visited[0][0] = true;
        while(!pq.isEmpty()) {
            Point front = pq.poll();
            for(int d = 0;d < 4;++d) {
                int nr = front.r + DIR[d][0];
                int nc = front.c + DIR[d][1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc]) continue;
                if(nr == m - 1 && nc == n - 1) return Math.max(grid[nr][nc], front.time);
                pq.add(new Point(nr, nc, Math.max(grid[nr][nc], front.time)));
                visited[nr][nc] = true;
            }
        }
        return grid[m - 1][n - 1];
    }
}