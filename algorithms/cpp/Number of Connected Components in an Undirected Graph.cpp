class Solution {
public:
    void dfs(const int& node, vector<int>& visited, const vector<vector<int> >& nergbers) {
        for(vector<int>::const_iterator it = nergbers[node].begin();it != nergbers[node].end();++it) {
            if(visited[*it] == 0) {
                visited[*it] = 1;
                dfs(*it, visited, nergbers);
            }
        }
    }
    
    int countComponents(int n, vector<pair<int, int> >& edges) {
        vector<vector<int> > nergbers(n);
        for(size_t i = 0;i < edges.size();++i) {
            nergbers[edges[i].first].push_back(edges[i].second);
            nergbers[edges[i].second].push_back(edges[i].first);
        }
        
        int num_of_components = 0;
        vector<int> visited(n, 0);
        for(int i = 0;i < n;++i) {
            if(visited[i] == 0) {
                num_of_components++;
                visited[i] = 1;
                dfs(i, visited, nergbers);
            }
        }
        
        return num_of_components;
    }
};