class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int l = 1;
        int j = 1;
        for(int i = 1;i < nums.size();++i) {
            if(nums[i] == nums[j - 1] && l >= 2) continue;
            else {
                nums[j] = nums[i];
                if(nums[i] == nums[j - 1]) l++;
                else l = 1;
                j++;
            }
        }
        
        return j;
    }
};