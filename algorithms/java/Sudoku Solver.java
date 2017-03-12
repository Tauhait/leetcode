public class Solution {
    public class FillPoint {
        public int r;
        public int c;
        public int val;
        
        public FillPoint(int _r, int _c, int _val) {
            r = _r;
            c = _c;
            val = _val;
        }
    }
    
    int[][] row;
    int[][] col;
    int[][][] squ;
    
    ArrayList<FillPoint> arr;
    
    void dfs(int d, char[][] board) {
        if(d == arr.size()) {
            for(int i = 0;i < arr.size();++i) {
                FillPoint p = arr.get(i);
                board[p.r][p.c] = (char) (p.val + '0');
            }
            return;
        }
        
        FillPoint p = arr.get(d);
        for(int i = 1;i <= 9;++i) {
            if(row[p.r][i] == 0 && col[p.c][i] == 0 && squ[p.r / 3][p.c / 3][i] == 0) {
                p.val = i;
                row[p.r][i] = 1;
                col[p.c][i] = 1;
                squ[p.r / 3][p.c / 3][i] = 1;
                
                dfs(d + 1, board);
                
                p.val = -1;
                row[p.r][i] = 0;
                col[p.c][i] = 0;
                squ[p.r / 3][p.c / 3][i] = 0;
            }
        }
    }
    
    public void solveSudoku(char[][] board) {
        row = new int[9][10];
        col = new int[9][10];
        squ = new int[3][3][10];
        for(int i = 0;i < 9;i++) {
            Arrays.fill(row[i], 0);
            Arrays.fill(col[i], 0);
        }
        for(int i = 0;i < 3;++i) {
            for(int j = 0;j < 3;++j) {
                Arrays.fill(squ[i][j], 0);
            }
        }
        
        arr = new ArrayList<>();
        for(int i = 0;i < 9;++i) {
            for(int j = 0;j < 9;++j) {
                if(board[i][j] != '.') {
                    row[i][board[i][j] - '0'] = 1;
                    col[j][board[i][j] - '0'] = 1;
                    squ[i / 3][j / 3][board[i][j] - '0'] = 1;
                } else {
                    arr.add(new FillPoint(i, j, -1));
                }
            }
        }
        
        
        dfs(0, board);
    }
}