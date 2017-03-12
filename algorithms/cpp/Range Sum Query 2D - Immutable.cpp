class NumMatrix {
public:
    vector<vector<int> > sum;
    
    NumMatrix(vector<vector<int> > &matrix) {
        if(matrix.size() == 0) return ;
        int m = matrix.size();
        if(matrix[0].size() == 0) return ;
        int n = matrix[0].size();
        
        sum.resize(m);
        for(size_t i = 0;i < m;++i) {
            sum[i].resize(n);
            sum[i][0] = matrix[i][0];
            for(size_t j = 1;j < n;++j) {
                sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }
        
        for(size_t j = 0;j < n;++j) {
            //sum[0][j] = sum[0][j];
            for(size_t i = 1;i < m;++i) {
                sum[i][j] = sum[i - 1][j] + sum[i][j];
            }
        }
        
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        if(row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0) {
            return 0;
        }
        
        if(row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        }
        
        if(row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        }
        
        if(col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        }
        
        return sum[row2][col2] - sum[row2][col1 - 1] 
           - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
};


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);