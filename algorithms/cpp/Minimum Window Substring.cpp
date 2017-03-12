class Solution {
public:
    string minWindow(string s, string t) {
        int count[256] = {0};
        for(int i = 0;i < t.size();++i) {
            count[t[i]]++;
        }
        int unique = 0;
        for(int i = 0;i < 256;++i) {
            if(count[i] > 0) {
                unique++;
            }
        }
        
        int start = 0;
        int contain = 0;

        int min_len = INT_MAX;
        int min_start = -1;
        for(int i = 0;i < s.size();++i) {
            count[s[i]]--;
            if(count[s[i]] == 0) {
                contain++;
            }
            if(contain == unique) {
                while(count[s[start]] < 0) {
                    count[s[start]]++;
                    start++;
                }
                if(i - start + 1 < min_len) {
                    min_len = i - start + 1;
                    min_start = start;
                }
                
                count[s[start]]++;
                start++;
                contain--;
            }
        }
        
        if(min_start == -1) {
            return "";
        } else {
            return s.substr(min_start, min_len);
        }
    }
};