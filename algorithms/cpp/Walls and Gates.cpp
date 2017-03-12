class Solution {
public:
    void wallsAndGates(vector<vector<int>>& rooms) {
        int m = rooms.size();
        if(m == 0) return;
        
        int n = rooms[0].size();
        if(n == 0) return ;
        
        int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        
        for(int i = 0;i < m;++i) {
            for(int j = 0;j < n;++j) {
                if(rooms[i][j] == 0) {
                    queue<pair<int, int> > q;
                    q.push(make_pair(i, j));
                    int lev = 0;
                    while(!q.empty()) {
                        int s = q.size();
                        lev = lev + 1;
                        for(int l = 0;l < s;++l) {
                            pair<int, int> front = q.front();
                            q.pop();
                            for(int k = 0;k < 4;++k) {
                                int r = front.first + dir[k][0];
                                int c = front.second + dir[k][1];
                                if(r >= 0 && r < m && c >= 0 && c < n && rooms[r][c] != -1) {
                                    if(rooms[r][c] <= lev) continue;
                                    else {
                                        q.push(make_pair(r, c));
                                        rooms[r][c] = lev;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
};