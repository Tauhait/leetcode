class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> ret;
        if(nums.size() == 0) return ret;
        int cand1, counter1 = 0;
        int cand2, counter2 = 0;
        
        for(int i = 0;i < nums.size();++i) {
            if(counter1 == 0 && nums[i] != cand2) {
                cand1 = nums[i];
                counter1 = 1;
            } else if(counter2 == 0 && nums[i] != cand1) {
                cand2 = nums[i];
                counter2 = 1;
            } else if(nums[i] == cand1) {
                counter1++;
            } else if(nums[i] == cand2) {
                counter2++;
            } else {
                counter1--;
                counter2--;
            }
        }
        counter1 = 0, counter2 = 0;
        for(int i = 0;i < nums.size();++i) {
            if(nums[i] == cand1) counter1++;
            if(nums[i] == cand2) counter2++;
        }
        if(counter1 > nums.size() / 3) ret.push_back(cand1);
        if(counter2 > nums.size() / 3 && cand1 != cand2) ret.push_back(cand2);
        
        return ret;
    }
};