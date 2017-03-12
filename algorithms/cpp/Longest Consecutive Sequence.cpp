class Solution {
public:
    int find_length(const int& num, unordered_map<int, int>& hash_table, vector<int>& max_length) {
        if(hash_table.find(num) == hash_table.end()) {
            return 0;
        }
        
        if(max_length[hash_table[num]] != 0) return max_length[hash_table[num]];
        
        max_length[hash_table[num]] = find_length(num - 1, hash_table, max_length) + 1;
        
        return max_length[hash_table[num]];
    }
    
    int longestConsecutive(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        unordered_map<int, int> hash_table;
        for(int i = 0;i < nums.size();++i) {
            hash_table.insert(make_pair(nums[i], i));
        }
        
        vector<int> max_length(nums.size(), 0);
        int ret = 0;
        for(int i = 0;i < nums.size();++i) {
            ret = max(ret, find_length(nums[i], hash_table, max_length));
        }
        
        return ret;
    }
};