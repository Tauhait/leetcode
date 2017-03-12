class Solution {
public:
    bool tag;
    vector<list<int> > neighbor_table;
    void dfs(const int& node, const int& pre, vector<int>& visited) {
        if(tag == false) return ;
        visited[node] = 1;
        for(list<int>::iterator it = neighbor_table[node].begin();it != neighbor_table[node].end();++it) {
            if(*it != pre) {
                if(visited[*it] == 1) {
                    tag = false;
                    return;
                }
                dfs(*it, node, visited);
            } 
        }
    }
    bool validTree(int n, vector<pair<int, int> >& edges) {
        if(edges.size() != n - 1) return false;
        neighbor_table.resize(n);
        for(size_t i = 0;i < edges.size();++i) {
            neighbor_table[edges[i].first].push_back(edges[i].second);
            neighbor_table[edges[i].second].push_back(edges[i].first);
        }
        
        vector<int> visited(n, 0);
        tag = true;
        dfs(0, -1, visited);
        
        return tag;
    }
};