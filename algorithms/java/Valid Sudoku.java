public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][][] squ = new int[3][3][10];
        
        for(int i = 0;i < 9;i++) {
            Arrays.fill(row[i], 0);
            Arrays.fill(col[i], 0);
        }
        for(int i = 0;i < 3;++i) {
            for(int j = 0;j < 3;++j) {
                Arrays.fill(squ[i][j], 0);
            }
        }
        
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;++j) {
                if(board[i][j] == '.') continue;
                
                int c = (int) (board[i][j] - '0');
                if(row[i][c] == 0) row[i][c] = 1;
                else return false;
                
                if(col[j][c] == 0) col[j][c] = 1;
                else return false;
                
                if(squ[i / 3][j / 3][c] == 0)  squ[i / 3][j / 3][c] = 1;
                else return false;
            }
        }
        
        return true;
    }
}