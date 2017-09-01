class Solution {
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        if(m == 0) return 0;
        int n = image[0].length;
        if(n == 0) return 0;
        
        int minX = x;
        int maxX = x;
        int minY = y;
        int maxY = y;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while(!q.isEmpty()) {
            int[] front = q.poll();
            for(int d = 0;d < 4;++d) {
                int r = front[0] + dir[d][0];
                int c = front[1] + dir[d][1];
                if(r >= 0 && r < m && c >= 0 && c < n && image[r][c] == '1'
                  && visited[r][c] == false) {
                    minX = Math.min(minX, r);
                    maxX = Math.max(maxX, r);
                    minY = Math.min(minY, c);
                    maxY = Math.max(maxY, c);
                    q.add(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);        
    }
}