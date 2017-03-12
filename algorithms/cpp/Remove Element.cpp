class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int n = nums.size();
        if(n == 0) return 0;
        int i = 0, j = n - 1;
        while(i <= j) {
            if(nums[i] == val) {
                while(nums[j] == val && i < j) j--;
                if(i >= j) return i;
                swap(nums[i], nums[j]);
                i++;
                j--;
            } else {
                i++;
            }
        }
        
        return i;
    }
};