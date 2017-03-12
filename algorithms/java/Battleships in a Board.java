public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        if(m == 0) return 0;
        int n = board[0].length;
        if(n == 0) return 0;
        
        int res = 0;
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if((i >= 1 && board[i - 1][j] == 'X') || (j >= 1 && board[i][j - 1] == 'X')) continue;
                if(board[i][j] == '.') continue;
                res++;
                
            }
        }
        
        return res;
    }
}