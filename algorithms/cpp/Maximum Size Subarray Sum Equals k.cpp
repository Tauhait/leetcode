class Solution {
public:
    int maxSubArrayLen(vector<int>& nums, int k) {
        unordered_map<int, int> hash_table;
        int sum = 0, ret = 0;
        for(int i = 0;i < nums.size();++i) {
            sum += nums[i];
            if(sum == k) {
                ret = max(ret, i + 1);
            }
            
            if(hash_table.find(sum - k) != hash_table.end()) {
                ret = max(ret, i - hash_table[sum - k]);
            }
            if(hash_table.find(sum) == hash_table.end()) {
                hash_table.insert(make_pair(sum, i));
            }
        }
        
        return ret;
    }
};