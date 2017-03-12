class Solution {
public:
    int m;
    int n;
    
    const int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    bool dfs(const vector<vector<char> >& board, const int& r, const int& c,
        vector<vector<bool> >& visited, const string& word, const size_t& wordindex) {
        
        if(wordindex == word.size()) {
            return true;
        }
        
        for(int i = 0;i < 4;++i) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }
            
            if(visited[nr][nc] == true) {
                continue;
            }
            
            if (board[nr][nc] != word[wordindex]) {
                continue;
            }
            
            visited[nr][nc] = true;
            if(dfs(board, nr, nc, visited, word, wordindex + 1)) {
                return true;
            }
            visited[nr][nc] =false;
        }
        
        return false;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        if(word.size() == 0) return true;
        m = board.size();
        if(m == 0) return false;
        n = board[0].size();
        
        vector<vector<bool> > visited(m, vector<bool>(n, false));
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(board[i][j] == word[0]) {
                    visited[i][j] = true;
                    if(dfs(board, i, j, visited, word, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }
};