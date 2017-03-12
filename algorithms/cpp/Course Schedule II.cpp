class Solution {
public:
    vector<int> findOrder(int numCourses, vector<pair<int, int>>& prerequisites) {
        vector<list<int> > edges(numCourses);
        vector<int> degree(numCourses, 0);
        for(int i = 0;i < prerequisites.size();++i) {
            edges[prerequisites[i].second].push_back(prerequisites[i].first);
            degree[prerequisites[i].first]++;
        }
        
        queue<int> q;
        for(int i = 0;i < numCourses;++i) {
            if(degree[i] == 0) q.push(i); 
        }
        
        vector<int> ret;
        while(!q.empty()) {
            int id = q.front();
            q.pop();
            
            ret.push_back(id);
            
            for(list<int>::iterator it = edges[id].begin();it != edges[id].end();++it) {
                degree[*it]--;
                if(degree[*it] == 0) q.push(*it);
            } 
        }
        
        if(ret.size() == numCourses) {
            return ret;
        } else {
            ret.clear();
            return ret;
        }
    }
};