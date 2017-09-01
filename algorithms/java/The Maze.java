class Solution {
    private static int[][] dir = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    private boolean getNewPosition(int[] pos, int d, int m, int n, int[] newPos, boolean[][] visited, int[][] maze) {
        int r = pos[0] + dir[d][0];
        int c = pos[1] + dir[d][1];
        int step = 1;
        while(r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0) {
            r += dir[d][0];
            c += dir[d][1];
            step++;
        }
        r -= dir[d][0];
        c -= dir[d][1];
        step--;
        
        if(step == 0) return false;
        if(visited[r][c]) return false;
        newPos[0] = r;
        newPos[1] = c;
        return true;
    }
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            for(int d = 0;d < 4;++d) {
                int[] newPos = new int[2];
                if(getNewPosition(pos, d, m, n, newPos, visited, maze)) {
                    visited[newPos[0]][newPos[1]] = true;
                    if(newPos[0] == destination[0] && newPos[1] == destination[1]) return true;
                    q.add(newPos);
                }
            }
        }
        return false;
    }
}