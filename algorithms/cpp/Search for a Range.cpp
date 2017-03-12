class Solution {
public:
    int upperBound(const vector<int>& nums, const int& target) {
        int l = 0, h = nums.size() - 1;
        while(l < h) {
            int m = l + (h - l + 1) / 2;
            if(nums[m] > target) h = m - 1;
            else if(nums[m] < target) l = m + 1;
            else if(nums[m] == target) l = m;
        }
        
        if(nums[h] == target) return l;
        else return -1;
    }
    
    int lowerBound(const vector<int>& nums, const int& target) {
        int l = 0, h = nums.size() - 1;
        while(l < h) {
            int m = l + (h - l) / 2;
            if(nums[m] > target) h = m - 1;
            else if(nums[m] < target) l = m + 1;
            else if(nums[m] == target) h = m;
        }
        
        if(nums[h] == target) return l;
        else return -1;
        
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> boundary(2, -1);
        if(nums.size() == 0) return boundary;
        
        boundary[0] = lowerBound(nums, target);
        boundary[1] = upperBound(nums, target);
        
        return boundary;
    }
};