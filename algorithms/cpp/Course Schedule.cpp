class Solution {
public:
    vector<set<int> > edge;
    vector<bool> visited;
    vector<bool> finished;
    
    bool hasCycle(const int& node) {
        set<int>& cur = edge[node];
        for(set<int>::iterator it = cur.begin();it != cur.end();++it) {
            if(finished[*it]) continue;
            
            if(visited[*it]) {
                return true;
            }
            
            visited[*it] = true;
            if(hasCycle(*it)) return true;
            finished[*it] = 2;
        }
        
        return false;
    }
    
    bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
        edge.resize(numCourses);
        visited.resize(numCourses);
        finished.resize(numCourses);
        
        for(int i = 0;i < prerequisites.size();++i) {
            edge[prerequisites[i].second].insert(prerequisites[i].first);
        }
        
        fill(visited.begin(), visited.end(), false);
        fill(visited.begin(), visited.end(), false);
        for(int i = 0;i < numCourses;++i) {
            if(visited[i] == false) {
                visited[i] = true;
                if(hasCycle(i)) return false;
                finished[i] = true;
            }
        }
        
        return true;
    }
};