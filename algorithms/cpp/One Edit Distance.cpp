class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        int ls = s.size(), lt = t.size();
        if(ls - lt > 1 || lt - ls > 1) return false;
        
        if(ls == lt) {
            int mis = 0;
            for(int i = 0;i < ls;++i) {
                if(s[i] != t[i]) {
                    mis++;
                }
            }
            return mis == 1;
        }
        
        int i = 0;
        while(i < ls && i < lt) {
            if(s[i] == t[i]) i++;
            else break;
        }
        
        int j = ls - 1;
        int k = lt - 1;
        while(j >= 0 && k >= 0 && s[j] == t[k]) {
            j--;
            k--;
        }
        
        if(ls > lt) {
            if(k < i) return true;
            return false;
        }
        if(ls < lt) {
            if(j < i) return true;
            return false;
        }
    }
};