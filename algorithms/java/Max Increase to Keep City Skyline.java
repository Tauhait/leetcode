class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = m == 0 ? 0 : grid[0].length;
        if(m == 0 || n == 0) return 0;
        
        int[] topDown = new int[n];
        int[] leftRight = new int[m];
        for(int i = 0;i < n;++i) {
            for(int j = 0;j < m;++j) {
                topDown[i] = Math.max(topDown[i], grid[j][i]);
            }
        }
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                leftRight[i] = Math.max(leftRight[i], grid[i][j]);
            }
        }
        
        int total = 0;
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                total += Math.max(0, Math.min(leftRight[i], topDown[j]) - grid[i][j]);
            }
        }
        return total;
    }
}