class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        vector<vector<int> > rows(9, vector<int>(9, 0));
        vector<vector<int> > cols(9, vector<int>(9, 0));
        int diag[3][3][9] = {0};
        for(int i = 0;i < 9;++i) {
            for(int j = 0;j < 9;++j) {
                if(board[i][j] != '.' && !(board[i][j] >= '1' && board[i][j] <= '9')) return false;
                else if(board[i][j] == '.') {
                    continue;
                } else {
                    if(rows[i][board[i][j] - '0' - 1] == 1) return false;
                    rows[i][board[i][j] - '0' - 1] = 1;
                    
                    if(cols[j][board[i][j] - '0' - 1] == 1) return false;
                    cols[j][board[i][j] - '0' - 1] = 1;
                    
                    if(diag[i/3][j/3][board[i][j] - '0' - 1] == 1) return false;
                    diag[i/3][j/3][board[i][j] - '0' - 1] = 1;
                }
            }
        }
        
        return true;
    }
};