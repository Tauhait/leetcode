class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int dir[][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        vector<int> ret;
        int m = matrix.size();
        if(m == 0) {
            return ret;
        }
        
        int n = matrix[0].size();
       
        int i = 0, j = 0;
        int d = 0;
        int ru = 0, rd = m - 1, cl = 0, cr = n - 1;
        ret.push_back(matrix[i][j]);
        int k = m * n - 1;
        while(k) {
            int r = i + dir[d][0];
            int c = j + dir[d][1];
            if(r >= ru && r <= rd && c >= cl && c <= cr) {
                i = r;
                j = c;
                ret.push_back(matrix[i][j]);
                k--;
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
        return ret;
    }
};