class Solution {
public:
    vector<vector<int> > ret;
    
    void dfs(const int& n, const int& index, vector<int>& cur, const int& sum,
        const int& target, const vector<pair<int, int> >& count) {
        if(sum == target) {
            ret.push_back(cur);   
            return;
        }
        if(sum > target) return;
        if(n == index) return;
        
        for(int i = 0;i <= count[index].second;++i) {
            for(int j = 0;j < i;++j) {
                cur.push_back(count[index].first);
            }
            dfs(n, index + 1, cur, sum + i *count[index].first, target, count);
            for(int j = 0;j < i;++j) {
                cur.pop_back();
            }
        }
    }
    
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        map<int, int> hash_table;
        for(size_t i = 0;i < candidates.size();++i) {
            hash_table[candidates[i]]++;
        }
        
        vector<pair<int, int> > count;
        for(map<int, int>::iterator it = hash_table.begin();it != hash_table.end();++it) {
            count.push_back(make_pair(it->first, it->second));
        }
        
        vector<int> cur;
        int n = count.size();
        dfs(n, 0, cur, 0, target, count);
        
        return ret;
    }
};