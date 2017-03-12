class Solution {
public:
    bool search(vector<int>& nums, int target) {
        if(nums.size() == 0) return -1;
        
        int l = 0, h = nums.size() - 1;
        while(l <= h) {
            int m = (l + h) / 2;
            if(target == nums[l]) return true;
            if(target == nums[m]) return true;
            
            if(nums[m] == nums[l]) {
                l++;
            } else if(nums[m] > nums[l]) {
                if(target > nums[m]) {
                    l = m + 1;
                } else {
                    if(target > nums[l]) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            } else {
                if(target < nums[m]) {
                    h = m - 1;
                } else {
                    if(target > nums[l]) {
                        h = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
        }
        
        return false;
    }
};