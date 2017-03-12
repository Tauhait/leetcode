class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        if(s.size() == 0 || s.size() == 1) {
            return s.size();
        }
        int n = s.size();
        vector<int> count(256, 0);
        int unique = 0, start = 0, max_len = 0;
        for(int i = 0;i < n;++i) {
            count[s[i]]++;
            if(count[s[i]] == 1) {
                unique++;
            }
            
            if(unique > 2) {
                max_len = max(max_len, i - start);
                while(unique > 2) {
                    count[s[start]]--;
                    if(count[s[start]] == 0) {
                        unique--;
                    }
                    start++;
                }
            }
        }
        max_len = max(max_len, n - start);
        
        return max_len;
    }
};