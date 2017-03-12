class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> hash_table;
        for(size_t i = 0;i < nums.size();++i) {
            if(hash_table.find(nums[i]) != hash_table.end()) {
                return true;
            }
            hash_table.insert(nums[i]);
        }
        
        return false;
    }
};