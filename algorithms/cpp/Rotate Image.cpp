class Solution {
public:
    void rotate(vector<vector<int> >& matrix) {
        int n = matrix.size();
        if(n == 0) return ;
        
        for(int i = 0;i < n / 2;++i) {
            //swap row i and n - i - 1
            for(int j = 0;j < n;++j) {
                swap(matrix[i][j], matrix[n - i - 1][j]);
            }
        }
        
        // swap by diagonal
        for(int i = 0;i < n;++i) {
            for(int j = i + 1;j < n;++j) {
                swap(matrix[i][j], matrix[j][i]);
            }
        }
    }
};