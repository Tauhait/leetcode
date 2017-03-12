class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        if(nums.size() == 0) return 0;
        if(nums.size() == 1) {
            if(target <= nums[0]) return 0;
            return 1;
        }
        
        
        int l = 0, h = nums.size() - 1;
        while(l <= h) {
            int m = (l + h) / 2;
            if(nums[m] == target) {
                return m;
            } else if(nums[m] > target) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
};