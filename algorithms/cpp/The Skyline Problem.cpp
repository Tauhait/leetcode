class Solution {
public:
    vector<pair<int, int> > getSkyline(vector<vector<int>>& buildings) {
        int n = buildings.size();
        vector<pair<int, int> > ret;
        if(n == 0) return ret;
        vector<pair<int, int> > positions(2 * n);
        for(int i = 0;i < n;++i) {
            positions[i * 2] = make_pair(buildings[i][0], -buildings[i][2]);
            positions[i * 2 + 1] = make_pair(buildings[i][1], buildings[i][2]);
        }
        sort(positions.begin(), positions.end());
        
        priority_queue<int, vector<int>, less<int> > q;
        unordered_map<int, int> mp;
        int pre = 0;
        for(int i = 0;i < 2 * n;++i) {
            if(positions[i].second < 0) {
                q.push(-positions[i].second);
            } else {
                mp[positions[i].second]++;
            }
            
            while(!q.empty() && mp[q.top()] > 0) {
                mp[q.top()]--;
                q.pop();
            }
            
            if(q.empty() && pre != 0) {
                ret.push_back(make_pair(positions[i].first, 0));
                pre = 0;
            } else if(q.top() != pre) {
                ret.push_back(make_pair(positions[i].first, q.top()));
                pre = q.top();  
            }
        }
        
        return ret;
    }
};