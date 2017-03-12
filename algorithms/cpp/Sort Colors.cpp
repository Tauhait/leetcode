class Solution {
public:
    void sortColors(vector<int>& nums) {
        int c[3] = {0};
        for(int i = 0;i < nums.size();++i) {
            c[nums[i]]++;
        }
        for(int i = 0;i < c[0];++i) {
            nums[i] = 0;
        }
        for(int i = c[0];i < c[0] + c[1];++i) {
            nums[i] = 1;
        }
        for(int i = c[0] + c[1];i < nums.size();++i) {
            nums[i] = 2;
        }
    }
};