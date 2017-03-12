class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        vector<int> ret;
        int x = 0;
        for(int i = 0;i < nums.size();++i) {
            x ^= nums[i];
        }
        
        int index = 1;
        for(int i = 0;i < 32;++i) {
            int y = x & index;
            if(y != 0) {
                break;
            }
            index <<= 1;
        }

        int num1 = 0, num2 = 0;
        for(int i = 0;i < nums.size();++i) {
            if((nums[i] & index) == 0) num1 ^= nums[i];
            else num2 ^= nums[i];
        }
        
       ret.push_back(num1);
       ret.push_back(num2);
       
       return ret;
    }
};