class Solution {
    private int count(char c, String[] board) {
        int cnt = 0;
        for(int i = 0;i < board.length;++i) {
            for(int j = 0;j < board[i].length();++j)
                if(board[i].charAt(j) == c) cnt++;
        }
        return cnt;
    }
    
    private int countSuccess(char c, String[] board) {
        // row
        int cnt = 0;
        for(int i = 0;i < 3;++i) {
            boolean f = true;
            for(int j = 0;j < 3;++j) {
                if(board[i].charAt(j) != c) {
                    f = false;
                    break;
                }
              
            }
            if(f) cnt++;
        }
        // column
        for(int j = 0;j < 3;++j) {
            boolean f = true;
            for(int i = 0;i < 3;++i) {
                if(board[i].charAt(j) != c) {
                    f = false;
                    break;
                }
               
            } 
            if(f) cnt++;
        }
        // diag
        boolean f = true; 
        for(int i = 0;i < 3;++i) {
            if(board[i].charAt(i) != c) {
                f = false;
                break;
            }
        }
        if(f) cnt++;
        
        // anti-diag
        f = true;
        for(int i = 0;i < 3;++i) {
            if(board[2 - i].charAt(i) != c) {
                f = false;
                break;
            }
        }
        if(f) cnt++;
        return cnt;
    }
    
    public boolean validTicTacToe(String[] board) {
        int countX = count('X', board);
        int countO = count('O', board);
        if(countO > countX) return false;
        if(countX - countO > 1) return false;
        int countXS = countSuccess('X', board);
        int countOS = countSuccess('O', board);
        if(countXS > 1 || countOS > 1) return false;
        if(countXS == 1 && countX == countO) return false;
        if(countXS == 1 && countOS == 1) return false;
        if(countOS == 1 && countX > countO) return false;
        return true;
    }
    
}