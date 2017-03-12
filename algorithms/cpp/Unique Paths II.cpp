class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int> >& obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        
        int m = obstacleGrid.size();
        if(m == 0) return 0;
        int n = obstacleGrid[0].size();
        if(n == 0) return 0;
        
        vector<vector<int> > path(m, vector<int>(n, 0));
        path[0][0] = 1;
        for(int i = 1;i < n;++i) {
            if(obstacleGrid[0][i] == 1) {
                path[0][i] = 0;
            } else {
                path[0][i] = path[0][i - 1];
            }
            
        }
        
        for(int j = 1;j < m;++j) {
            if(obstacleGrid[j][0] == 1) {
                path[j][0] = 0;
            } else {
                path[j][0] = path[j - 1][0];
            }
        }
        
        for(int i = 1;i < m;++i) {
            for(int j = 1;j < n;++j) {
                if(obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
        
        return path[m - 1][n - 1];
    }
};