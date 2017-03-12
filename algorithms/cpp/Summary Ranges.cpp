class Solution {
public:
    string int2str(const int& num) {
        char chr[20];
        sprintf(chr, "%d", num);
        string ret = chr;
        return ret;
    }
    
    vector<string> summaryRanges(vector<int>& nums) {
        string cur;
        int n = nums.size();
        vector<string> ret;
        if(n == 0) return ret;
        cur = int2str(nums[0]);
        int c = 1;
        for(int i = 1;i < n;++i) {
            if(nums[i] != nums[i - 1] + 1) {
                if(c == 1) {
                    ret.push_back(cur);
                    cur = int2str(nums[i]);
                    c = 1;
                } else {
                    cur += "->";
                    cur += int2str(nums[i - 1]);
                    ret.push_back(cur);
                    cur = int2str(nums[i]);
                    c = 1;
                }
            } else {
                c++;
            }
        }
        if(c == 1) {
            ret.push_back(cur);
        } else {
            cur += "->";
            cur += int2str(nums[n - 1]);
            ret.push_back(cur);
        }
        return ret;
    }
};