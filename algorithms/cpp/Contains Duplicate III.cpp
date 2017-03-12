class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        if(k <= 0) return false;
        
        set<int> hash_table;
        int j = 0;
        for(int i = 0;i < nums.size();++i) {
            set<int>::iterator it = hash_table.lower_bound(nums[i] - t);
            if(it != hash_table.end()) {
                if((*it) <= nums[i]) return true;
                else if((*it) > nums[i] && (*it) <= nums[i] + t) return true;
            }
            
            if(hash_table.size() == k) {
                hash_table.erase(nums[j]);
                j++;
            }
            hash_table.insert(nums[i]);
        }
        
        return false;
    }
};