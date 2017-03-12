class Solution {
public:
    static bool sortCMP(const string& a, const string& b) {
        int la = a.size();
        int lb = b.size();
        
        int i = 0, j = 0;
        while(i < la && j < lb) {
            if(a[i] > b[j]) return true;
            else if(a[i] < b[j]) return false;
            
            i++;
            j++;
            
            if(i == la && j == lb) return false;
            else if(i == la) i = 0;
            else if(j == lb) j = 0;
        }
    }
    
    string num2string(const int& num) {
        char chr[40];
        sprintf(chr, "%d", num);
        return string(chr);
    }
    
    string largestNumber(vector<int>& nums) {
        vector<string> digits(nums.size());
        for(int i = 0;i < nums.size();++i) {
            digits[i] = num2string(nums[i]);
        }
        
        sort(digits.begin(), digits.end(), sortCMP);
        
        string ret;
        for(int i = 0;i < digits.size();++i) {
            ret += digits[i];
        }
        int i = 0;
        while(ret[i] == '0') i++;
        if(i == ret.size()) return "0";
        else return ret.substr(i);
    }
};