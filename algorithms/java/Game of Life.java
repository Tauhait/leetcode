class Solution {
    private int numOfLivedNeighbors(int r, int c, int[][] board, int m, int n) {
        int count = 0;
        for(int i = -1;i <= 1;++i) {
            for(int j = -1;j <= 1;++j) {
                if(i == 0 && j == 0) continue;
                int nr = r + i;
                int nc = c + j;
                if(nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if(isOrginalLived(r + i, c + j, board)) count++;
            }
        }
        return count;
    }
    
    private boolean isOrginalLived(int r, int c, int[][] board) {
        return (board[r][c] & 0b0001) == 1; 
    }
    
    private void setNewLive(int r, int c, int[][] board) {
        board[r][c] |= 0b0010;
    }
    
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = m == 0 ? 0 : board[0].length;
        if(m == 0 || n == 0) return;
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                int livedNeighbors = numOfLivedNeighbors(i, j, board, m, n);
                if(isOrginalLived(i, j, board)) {
                    if(livedNeighbors == 2 || livedNeighbors == 3)
                        setNewLive(i, j, board);
                } else {
                    if(livedNeighbors == 3)
                        setNewLive(i, j, board);
                }
            }
        }
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                board[i][j] >>>= 1;
            }
        }
    }
}