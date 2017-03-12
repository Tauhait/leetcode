class Solution {
public:
    const int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int m;
    int n;
    
    void dfs(const int& r, const int& c, vector<vector<char> >& board) {
        stack<pair<int, int> > st;
        st.push(make_pair(r, c));
        while(!st.empty()) {
            int r = st.top().first;
            int c = st.top().second;
            st.pop();
            board[r][c] = 'Y';
            
            for(int i = 0;i < 4;++i) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O') {
                    st.push(make_pair(nr, nc));
                }
            }
        }
    }
    
    void solve(vector<vector<char> >& board) {
        m = board.size();
        if(m == 0) return ;
        n = board[0].size();
        
        for(int i = 0;i < m;++i) {
            if(board[i][0] == 'O') {
                dfs(i, 0, board);
            }
            if(board[i][n - 1] == 'O') {
                dfs(i, n - 1, board);
            }
        }
        for(int i = 0;i < n;++i) {
            if(board[0][i] == 'O') {
                dfs(0, i, board);
            }
            if(board[m - 1][i] == 'O') {
                dfs(m - 1, i, board);
            }
        }
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }
};