class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int> > ret;
        vector<int> res;
        ret.push_back(res);
        if(nums.size() == 0) {
            return ret;
        }
        map<int, int> hash_table;
        for(size_t i = 0;i < nums.size();++i) {
            hash_table[nums[i]]++;
        }
        
        for(map<int, int>::iterator it = hash_table.begin(); it != hash_table.end();++it) {
            size_t size = ret.size();
            for(size_t j = 0;j < size;++j) {  
                vector<int> res = ret[j];
                for(int i = 1;i <= it->second;++i) {
                    res.push_back(it->first);
                    ret.push_back(res);
                }
            }
        }
        
        return ret;
    }
};