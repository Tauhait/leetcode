class Solution {
public:
    string longestPalindrome(string s) {
        int ret = 0;
        string sret;
        for(int i = 0;i < s.size();++i) {
            int j = i, k = i;
            while(j >= 0 && k < s.size()) {
                if(s[j] == s[k]) {
                    j--;
                    k++;
                } else break;
            }
            if(k - j - 1 > ret) {
                ret = k - j - 1;
                sret = s.substr(j + 1, k - j - 1);
            }
        }
        
        for(int i = 0;i < s.size();++i) {
            int j = i, k = i + 1;
            while(j >= 0 && k < s.size()) {
                if(s[j] == s[k]) {
                    j--;
                    k++;
                } else break;
            }
            if(k - j - 1 > ret) {
                ret = k - j - 1;
                sret = s.substr(j + 1, k - j - 1);
            }
        }
        
        return sret;
    }
};