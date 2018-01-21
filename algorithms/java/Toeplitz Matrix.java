class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        if(m == 0 || n == 0) return true;
        
        // first column
        for(int i = 0;i < m;++i) {
            int first = matrix[i][0];
            int r = i + 1, c = 1;
            while(r < m && c < n) {
                if(matrix[r][c] != first) return false;
                r++;
                c++;
            }
        }
        
        // fisrt row
        for(int j = 1;j < n;++j) {
            int first = matrix[0][j];
            int r = 1, c = j + 1;
            while(r < m && c < n) {
                if(matrix[r][c] != first) return false;
                r++;
                c++;
            }
        }
        return true;
    }
}