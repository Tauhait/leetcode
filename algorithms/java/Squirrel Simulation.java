public class Solution {
    int m;
    int n;
    int numNuts;
    int[][] distTreeNut;
    int[][] distSquarNut;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    void bfs(int r, int c, int m, int n, int[][] dist) {
        int dis = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        dist[r][c] = 0;
        while(!q.isEmpty()) {
            dis++;
            int s = q.size();
            for(int i = 0;i < s;++i) {
                int[] f = q.poll();
                for(int d = 0;d < 4;++d) {
                    int nr = f[0] + dir[d][0];
                    int nc = f[1] + dir[d][1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                        dist[nr][nc] = dis;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }
    
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int numNuts = nuts.length;
        if(numNuts == 0) {
            return 0;
        }
        m = height;
        n = width;
        
        distTreeNut = new int[m][n];
        distSquarNut = new int[m][n];
        for(int i = 0;i < m;++i) {
            Arrays.fill(distTreeNut[i], -1);
            Arrays.fill(distSquarNut[i], -1);
        }
        
        bfs(tree[0], tree[1], m, n, distTreeNut);
        bfs(squirrel[0], squirrel[1], m, n, distSquarNut);
        
        int minDis = Integer.MAX_VALUE;
        for(int i = 0;i < numNuts;++i) {
            int d = 0;
            for(int j = 0;j < numNuts;++j) {
                if(j == i) {
                    d += distSquarNut[nuts[i][0]][nuts[i][1]] + distTreeNut[nuts[i][0]][nuts[i][1]];
                } else {
                    d += 2 * distTreeNut[nuts[j][0]][nuts[j][1]];
                }
            }
            minDis = Math.min(d, minDis);
        }
        
        return minDis;
    }
}
