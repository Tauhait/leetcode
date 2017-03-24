public class Solution {
    private int numOfMine(int r, int c, char[][] board, int m, int n) {
        int count = 0;
        for(int i = -1;i <= 1;++i) {
            for(int j = -1;j <= 1;++j) {
                if(i == 0 && j == 0) continue;
                int nr = r + i;
                int nc = c + j;
                if(nr >= m || nr < 0 || nc >= n || nc < 0) continue;
                if(board[nr][nc] == 'M') {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int r, int c, char[][] board, char[][] res, int m, int n) {
        int count = numOfMine(r, c, board, m, n);
        if(count > 0) {
            res[r][c] = (char) (count + '0');
            // res[r][c] = String.valueOf(count).charAt(0);
        } else {
            res[r][c] = 'B';
            for(int i = -1;i <= 1;++i) {
                for(int j = -1;j <= 1;++j) {
                    if(i == 0 && j == 0) continue;
                    int nr = r + i;
                    int nc = c + j;
                    if(nr >= m || nr < 0 || nc >= n || nc < 0) continue;
                    if(res[nr][nc] == 'E') {
                        dfs(nr, nc, board, res, m, n);
                    }
                }
            }
        }
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length;
        if(m == 0) {
            throw new RuntimeException("The matrix is empty");
        }
        int n = board[0].length;
        char[][] res = new char[m][n];
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                res[i][j] = board[i][j];
            }
        }
        int r = click[0];
        int c = click[1];
        if(board[r][c] == 'M') {
            res[r][c] = 'X';
            return res;
        }
        
        dfs(r, c, board, res, m, n);
        return res;
    }
}