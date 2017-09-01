public class Solution {
    private class Pair {
        int r;
        int c;
        public Pair(int fR, int fC) {
            r = fR;
            c = fC;
        }
    }
    
    private int m;
    private int n;
    private int numOfBuilding;
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    int distance(int r, int c, int[][] grid) {
        int totalDis = 0;
        int totalBuilds = 0;
        int dis = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < m;++i) {
            Arrays.fill(visited[i], false);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        visited[r][c] = true;
        while(!q.isEmpty()) {
            dis++;
            int s = q.size();
            for(int i = 0;i < s;++i) {
                Pair f = q.poll();
                for(int j = 0;j < 4;++j) {
                    int nr = f.r + dir[j][0];
                    int nc = f.c + dir[j][1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 2 && visited[nr][nc] == false) {
                        visited[nr][nc] = true;
                        if(grid[nr][nc] == 1) {
                            totalDis += dis;
                            totalBuilds++;
                        } else {
                            q.add(new Pair(nr, nc));
                        }
                    }
                }
            }
        }
        if(totalBuilds == numOfBuilding) {
            return totalDis;
        }
        return Integer.MAX_VALUE;
    }
    
    public int shortestDistance(int[][] grid) {
        m = grid.length;
        if(m == 0) {
            return -1;
        }
        n = grid[0].length;
        if(n == 0) {
            return -1;
        }
        numOfBuilding = 0;
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(grid[i][j] == 1) {
                    numOfBuilding++;
                }
            }
        }
        
        int minDis = Integer.MAX_VALUE;
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(grid[i][j] == 0) {
                    minDis = Math.min(minDis, distance(i, j, grid));
                }
            }
        }
        
        if(minDis == Integer.MAX_VALUE) {
            return -1;
        }
        return minDis;
    }
}