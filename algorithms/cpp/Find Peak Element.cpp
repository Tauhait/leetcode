class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.size() == 0 || nums.size() == 1 || nums[0] > nums[1]) return 0;
        if(nums[nums.size() - 1] > nums[nums.size() - 2]) return nums.size() - 1;
        
        int l = 0, h = nums.size() - 1;
        while(l <= h) {
            
            int m = (l + h) / 2;
            
            if(m != 0 && nums[m] < nums[m - 1]) h = m - 1;
            else if(m != nums.size() - 1 && nums[m] < nums[m + 1]) l = m + 1;
            else return m;
        }
    }
};