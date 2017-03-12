class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        if(nums.size() == 0 | nums.size() == 1) {
            return ;
        }
        
        for(int i = n - 1;i > 0;--i) {
            if(nums[i] > nums[i - 1]) {
                for(int j = n - 1;j >= 0;--j) {
                    if(nums[j] > nums[i - 1]) {
                        swap(nums[i - 1], nums[j]);
                        reverse(nums.begin() + i, nums.end());
                        return ;  
                    }
                }
            
            }
        }
        
        reverse(nums.begin(), nums.end());
    }
};