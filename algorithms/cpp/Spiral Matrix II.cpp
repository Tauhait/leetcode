class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        int dir[][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        vector<vector<int> > matrix(n, vector<int>(n, 0));
        if(n == 0) return matrix;
       
        int i = 0, j = 0;
        int d = 0;
        int ru = 0, rd = n - 1, cl = 0, cr = n - 1;
        matrix[i][j] = 1;
        int k = 2;
        while(k <= n * n) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if(r >= ru && r <= rd && c >= cl && c <= cr) {
                i = r;
                j = c;
                matrix[i][j] = k;
                k++;
            } else {
                if(d == 0) {
                    ru++;
                } else if(d == 1) {
                    cr--;
                } else if(d == 2) {
                    rd--;
                } else {
                    cl++;
                }
                d++;
                d %= 4;
            }
        }
        return matrix;
        
    }
};