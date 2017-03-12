class Solution {
public:
    vector<vector<int> > ret;
    vector<pair<int, int> > unique_nums;
    
    void dfs(const int& n, const int& index, vector<int>& cur) {
        if(n == index) {
            ret.push_back(cur);
            return ;
        }
        
        for(int i = 0;i < unique_nums.size();++i) {
            if(unique_nums[i].second > 0) {
                cur[index] = unique_nums[i].first;
                unique_nums[i].second--;
                dfs(n, index + 1, cur);
                unique_nums[i].second++;
            }
        }
    }
    
    vector<vector<int> > permuteUnique(vector<int>& nums) {
        unordered_map<int, int> hash_table;
        for(int i = 0;i < nums.size();++i) {
            hash_table[nums[i]]++;
        }
        
        for(unordered_map<int, int>::iterator it = hash_table.begin(); it != hash_table.end();++it) {
            unique_nums.push_back(make_pair(it->first, it->second));
        }
        
        int n = nums.size();
        vector<int> cur(n, 0);
        dfs(n, 0, cur);
        
        return ret;
    }
};