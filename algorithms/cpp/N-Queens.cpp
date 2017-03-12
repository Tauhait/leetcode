class Solution {
public:
    vector<vector<string> > ret;
    vector<int> col;
    vector<int> diag;
    vector<int> off_diag;
    
    void dfs(const int& r, vector<int>& row, const int& n) {
        if(r == n) {
            vector<string> s;
            for(int i = 0;i < n;++i) {
                if(row[i] == -1) return ;
                string sol(n, '.');
                sol[row[i]] = 'Q';
                s.push_back(sol);
            }
            ret.push_back(s);
        
            return ;    
        }
        
        for(int c = 0;c < n;++c) {
            if(col[c] == 0 
                && off_diag[r + c] == 0 
                && diag[r - c + n - 1] == 0) {
                    col[c] = 1;
                    off_diag[r + c] = 1;
                    diag[r - c + n - 1] = 1;
                    row[r] = c;
                    dfs(r + 1, row, n);
                    col[c]  = 0;
                    off_diag[r + c] = 0;
                    diag[r - c + n - 1] = 0;
                    row[r] = -1;
            }
        }
    }
    
    vector<vector<string> > solveNQueens(int n) {
        col.resize(n);
        diag.resize(2 * n - 1);
        off_diag.resize(2 * n - 1);
        for(int i = 0;i < n;++i) {
            col[i] = 0;
        }
        for(int i = 0;i < 2 * n - 1;++i) {
            diag[i] = 0;
            off_diag[i] = 0;
        }
        ret.clear();
        
        vector<int> row(n, -1);
        dfs(0, row, n);
        
        return ret;
    }
};