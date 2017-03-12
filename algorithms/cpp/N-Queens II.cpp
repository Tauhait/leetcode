class Solution {
public:
    vector<int> col;
    vector<int> diag;
    vector<int> off_diag;
    
    int ret;
    
    void dfs(const int& r, const int& n) {
        if(r == n) {
            ret++;
            
            return ;    
        }
        
        for(int c = 0;c < n;++c) {
            if(col[c] == 0 
                && off_diag[r + c] == 0 
                && diag[r - c + n - 1] == 0) {
                    col[c] = 1;
                    off_diag[r + c] = 1;
                    diag[r - c + n - 1] = 1;
                
                    dfs(r + 1, n);
                    col[c]  = 0;
                    off_diag[r + c] = 0;
                    diag[r - c + n - 1] = 0;
            }
        }
    }
    
    int totalNQueens(int n) {
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
        
        ret = 0;
        dfs(0, n);
        
        return ret;
    }
};