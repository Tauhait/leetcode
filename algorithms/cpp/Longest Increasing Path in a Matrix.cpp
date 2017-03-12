class Solution {
public:
    const int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int m;
    int n;
    int find_long_path(const int& r, const int& c, vector<vector<int> >& longest_path, const vector<vector<int> >& matrix) {
        if(longest_path[r][c] != 1) {
            return longest_path[r][c];
        }
        
        for(int i = 0;i < 4;++i) {
            int new_r = r + dir[i][0];
            int new_c = c + dir[i][1];
            if(new_r < 0 || new_c < 0 || new_r >= m || new_c >= n || matrix[new_r][new_c] <= matrix[r][c]) continue;
            longest_path[new_r][new_c] = find_long_path(new_r, new_c, longest_path, matrix);
            longest_path[r][c] = max(longest_path[r][c], 1 + longest_path[new_r][new_c]);
        }
        
        return longest_path[r][c];
    }
    
    int longestIncreasingPath(vector<vector<int> >& matrix) {
        m = matrix.size();
        if(m == 0) return 0;
        n = matrix[0].size();
        if(n == 0) return 0;
        
        // longest increaing path started from (i, j)
        vector<vector<int > > longest_path(m, vector<int>(n, 1));
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(longest_path[i][j] != 1) continue;
                longest_path[i][j] = find_long_path(i, j, longest_path, matrix);
            }
        }
        
        int ret = 0;
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                ret = max(ret, longest_path[i][j]);
            }
        }
        
        return ret;
    }
};