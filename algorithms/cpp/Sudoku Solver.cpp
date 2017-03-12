class Solution {
public:
    vector<pair<int, int> > dot;
    int found;

    void dfs(const int& n, const int& index, vector<vector<char> >& board, vector<vector<int> >& row,
        vector<vector<int> >& col, vector<vector<vector<int> > >& squ) {
        if(found == 1) return ;
        
        if(n == index) {
            found = 1;
            return ;
        }
        
        int i = dot[index].first;
        int j = dot[index].second;
        for(int k = 1;k <= 9;++k) {
            if(row[i][k] == 0 && col[j][k] == 0 && squ[i / 3][j / 3][k] == 0) {
                row[i][k] = 1;
                col[j][k] = 1;
                squ[i / 3][j / 3][k] = 1;
                board[i][j] = k + '0';
                
                dfs(n, index + 1, board, row, col, squ);
                if(found == 1) return ;
                row[i][k] = 0;
                col[j][k] = 0;
                squ[i / 3][j / 3][k] = 0;
                board[i][j] = '.';
            }
        }
    }
    
    void solveSudoku(vector<vector<char> >& board) {
        vector<vector<int> > row(10, vector<int>(10, 0));
        vector<vector<int> > col(10, vector<int>(10, 0));
        vector<vector<vector<int> > > squ(3, vector<vector<int> >(3, vector<int>(10, 0)));
        
        for(int i = 0;i < 9;++i) {
            for(int j = 0;j < 9;++j) {
                if(board[i][j] == '.') {
                    dot.push_back(make_pair(i, j));
                } else {
                    row[i][board[i][j] - '0'] = 1;
                    col[j][board[i][j] - '0'] = 1;
                    squ[i / 3][j / 3][board[i][j] - '0'] = 1;
                }
            }
        }
        
        int n = dot.size();
        int found = 0;
        dfs(n, 0, board, row, col, squ);
    }
};