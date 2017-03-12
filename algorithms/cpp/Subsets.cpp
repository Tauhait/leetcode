class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int> > ret;
        vector<int> res;
        ret.push_back(res);
        if(nums.size() == 0) return ret;
        sort(nums.begin(), nums.end());
        
        for(size_t i = 0;i < nums.size();++i) {
            size_t end = ret.size();
            for(int j = 0;j < end;++j) {
                vector<int> res = ret[j];
                res.push_back(nums[i]);
                ret.push_back(res);
            }
        }
        
        return ret;
    }
};