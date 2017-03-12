class Solution {
public:
    const int dir[8][2] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    int count_hegbers(const vector<vector<int> >& board, const int& r, const int& c, const int& m, const int& n) {
        int cntl = 0;
        for(int i = 0;i < 8;++i) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if(board[nr][nc] == 1) cntl++;
            }
        }
        
        return cntl;
    }
    void gameOfLife(vector<vector<int>>& board) {
        int m = board.size();
        if(m == 0) return ;
        int n = board[0].size();
        
        vector<vector<int> > n_board(m, vector<int>(n, 0));
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(board[i][j] == 0) {
                    int cntdl = count_hegbers(board, i, j, m, n);
                    if(cntdl == 3) n_board[i][j] = 1;
                } else {
                    int cntdl = count_hegbers(board, i, j, m, n);
                    if(cntdl < 2 || cntdl > 3) n_board[i][j] = 0;
                    else if(cntdl == 2 || cntdl == 3) n_board[i][j] = 1;
                }
            }
        }
        board = n_board;
    }
};