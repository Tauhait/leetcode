class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> hash_table;
        for(size_t i = 0;i < nums.size();++i) {
            unordered_map<int, int>::iterator it = hash_table.find(target - nums[i]);
            if(it != hash_table.end()) {
                return vector<int>{it->second, i};
            }
            
            hash_table.insert(make_pair(nums[i], i));
        }
    }
};