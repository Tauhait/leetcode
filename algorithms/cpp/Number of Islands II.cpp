class Solution {
public:
    const int dir[4][2] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    
    int find_root(int x, vector<int>& parent) {
        int t = x;
        while(t != parent[t]) {
            t = parent[t];
        }
        while(x != parent[x]) {
            int tmp = parent[x];
            parent[x] = t;
            x = tmp;
        }
        
        
        return t;
    }
    
    void join_union(int x, int y, vector<int>& parent) {
        parent[x] = parent[y];
    }
    
    vector<int> numIslands2(int m, int n, vector<pair<int, int> >& positions) {
        if(positions.size() == 0) return {0};
        vector<int> parent(m * n, -1);
        vector<int> ret;
        int num_of_island = 0;
        for(int i = 0;i < positions.size();++i) {
            int node = positions[i].first * n + positions[i].second;
            parent[node] = node;
            num_of_island++;
            for(int j = 0;j < 4;++j) {
                int r = positions[i].first + dir[j][0];
                int c = positions[i].second + dir[j][1];
                if(r >= 0 && c >= 0 && r < m && c < n && parent[r * n + c] != -1) {
                    int root_node = find_root(node, parent);
                    int root_adj = find_root(r * n + c, parent);
                    if(root_node != root_adj) {
                        join_union(root_node, root_adj, parent);
                        num_of_island--;
                    }
                }
            }
            
            ret.push_back(num_of_island);
        }
        
        return ret;
    }
};