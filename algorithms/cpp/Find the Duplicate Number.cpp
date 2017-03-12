class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int size = nums.size();
        int n = size - 1;
        int l = 1, h = n;
        while(l < h) {
            int m = (l + h) / 2;
            int count = 0;
            for(int i = 0;i < size;++i) {
                if(nums[i] <= m) {
                    count++;
                }
            }
            
            if(count <= m) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        
        return l;
    }
};