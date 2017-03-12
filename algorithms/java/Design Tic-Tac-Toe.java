public class TicTacToe {
    //char[][] board;
    int size;
    int[] rows;
    int[] cols;
    int diag;
    int anti_diag;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        size = n;
        Arrays.fill(rows, 0);
        Arrays.fill(cols, 0);
        diag = 0;
        anti_diag = 0;
       // board = new char[n][n];
    //    for(int i = 0;i < n;++i) {
      //      Arrays.fill(board[i], 'E');
       // }
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        boolean success = true;
        char chr = '_';
        if(player == 1) {
            chr = 'X';
            rows[row]++;
            cols[col]++;
            if(row == col) diag++;
            if(row + col == size - 1) anti_diag++;
        } else {
            chr = 'O';
            rows[row]--;
            cols[col]--;
            if(row == col) diag--;
            if(row + col == size - 1) anti_diag--;
        }
        
        if(rows[row] == size || rows[row] == -size) return player;
        if(cols[col] == size || cols[col] == -size) return player;
        if(row == col) {
            if(diag == size || diag == -size) return player;
        }
        if(row + col == size - 1) {
            if(anti_diag == size || anti_diag == -size) return player;
        }
        return 0;
        /*
        board[row][col] = chr;
        
        success = true;
        for(int i = 0;i < size;++i) {
            if(board[row][i] != chr) {success = false;break;}
        }
        if(success) return player;
        
        success = true;
        for(int i = 0;i < size;++i) {
            if(board[i][col] != chr) {success = false;break;}
        }
        if(success) return player;
        
        if(col == row) {
            success = true;
            for(int i = 0;i < size;++i) {
                if(board[i][i] != chr) {success = false;break;}
            }
            if(success) return player;
        }
        
        if(col + row == size - 1) {
            success = true;
            for(int i = 0;i < size;++i) {
                if(board[i][size - 1 - i] != chr) {success = false;break;}
            }
            if(success) return player;
        }
        
        return 0;*/
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */