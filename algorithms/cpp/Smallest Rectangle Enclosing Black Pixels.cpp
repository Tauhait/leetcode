class Solution {
public:
    int max_x;
    int max_y;
    int min_x;
    int min_y;
    
    const int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    void dfs(const int& r, const int& c, const vector<vector<char> >& image,
        const int& m, const int& n, vector<vector<int > >& visited) {
        //cout << r << " " << c << endl;
        max_x = max(max_x, r);
        max_y = max(max_y, c);
        
        min_x = min(min_x, r);
        min_y = min(min_y, c);
        
        //cout << max_x << " " << min_x << " " << max_y << " " << min_y << endl;
        
        for(int i = 0;i < 4;++i) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == '1' && visited[nr][nc] == 0) {
                visited[nr][nc] = 1;
                dfs(nr, nc, image, m, n, visited);
            }
        }
    }
    
    int minArea(vector<vector<char> >& image, int x, int y) {
        int m = image.size();
        if(m == 0) return 0;
        int n = image[0].size();
        if(n == 0) return 0;
        
        max_x = 0, max_y = 0, min_x = m, min_y = n;
        vector<vector<int> > visited(m, vector<int>(n, 0));
        visited[x][y] = 1;
        dfs(x, y, image, m, n, visited);
        //cout << max_x << " " << min_x << " " << max_y << " " << min_y << endl;
        return (max_x - min_x + 1) * (max_y - min_y + 1);
    }
};