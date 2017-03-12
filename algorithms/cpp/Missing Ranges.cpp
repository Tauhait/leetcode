class Solution {
public:
    char chr[100];
    vector<string> findMissingRanges(vector<int>& nums, int lower, int upper) {
        vector<string> ret;
        if(nums.size() == 0) {
            if(lower == upper) sprintf(chr, "%d", lower);
            else sprintf(chr, "%d->%d", lower, upper);
            ret.push_back(chr);
            
            return ret;
        }
      
        if(nums[0] == lower + 1) {
            sprintf(chr, "%d", lower);
            ret.push_back(chr);
        } else if(nums[0] > lower + 1) {
            sprintf(chr, "%d->%d", lower, nums[0] - 1);
            ret.push_back(chr);
        }
  
        for(int i = 1;i < nums.size();++i) {
            if(nums[i] == nums[i - 1] + 1) continue;
            else if(nums[i] == nums[i - 1] + 2) {
                sprintf(chr, "%d", nums[i - 1] + 1);
                ret.push_back(chr);
            } else if(nums[i] > nums[i - 1] + 2) {
                sprintf(chr, "%d->%d", nums[i - 1] + 1, nums[i] - 1);
                ret.push_back(chr);
            }
        }
     
        if(upper == nums[nums.size() - 1] + 1) {
            sprintf(chr, "%d", upper);
            ret.push_back(chr);
        } else if(upper > nums[nums.size() - 1] + 1) {
            sprintf(chr, "%d->%d", nums[nums.size() - 1] + 1, upper);
            ret.push_back(chr);
        }
        
        return ret;
    }
};