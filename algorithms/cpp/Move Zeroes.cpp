class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i = 0;
        for(int i = 0;i < nums.size();++i) {
            if(nums[i] == 0) {
                int j = i + 1;
                while(nums[j] == 0 && j < nums.size()) {
                    j++;
                }
                if(j == nums.size()) return ;
                swap(nums[i], nums[j]);
            }
        }
    }
};