class Solution {
public:
    int majorityElement(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        int cand = nums[0];
        int counter = 0;
        for(int i = 0;i < nums.size();++i) {
            if(counter == 0) {
                cand = nums[i];
                counter = 1;
            } else {
                if(nums[i] == cand) {
                    counter++;
                } else {
                    counter--;
                }
            }
        }
        
        return cand;
    }
};