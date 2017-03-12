class Solution {
public:
    const int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    int numIslands(vector<vector<char> >& grid) {
        int m = grid.size();
        if(m == 0) return 0;
        int n = grid[0].size();
        if(n == 0) return 0;
        
        vector<vector<bool> > visited(m, vector<bool>(n, false));
        
        int num_of_islands = 0;
        queue<pair<int, int> > q;
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(grid[i][j] == '1' && visited[i][j] == false) {
                    num_of_islands++;
                    visited[i][j] = true;
                    
                    q.push(make_pair(i, j));
                    while(!q.empty()) {
                        pair<int, int> front = q.front();
                        q.pop();
                        for(int k = 0;k < 4;++k) {
                            int nr = front.first + dir[k][0];
                            int nc = front.second + dir[k][1];
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && visited[nr][nc] == false && grid[nr][nc] == '1') {
                                visited[nr][nc] = true;
                                q.push(make_pair(nr, nc));
                            }
                        }
                    }
                    
                }
            }
        }
        
        return num_of_islands;
    }
};