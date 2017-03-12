class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.size() == 0 || s.size() == 1) {
            return s.size();
        }
        
        int max_len = 0;
        unordered_map<char, int> position;
        int start = 0, n = s.size();
        for(int i = 0;i < n;++i) {
            unordered_map<char, int>::iterator it = position.find(s[i]);
            if(it == position.end()) {
                position.insert(make_pair(s[i], i));
            } else {
                if(it->second < start) {
                    it->second = i;
                } else {
                    max_len = max(max_len, i - start);
                    start = it->second + 1;
                    it->second = i;
                }
            }
        }
        max_len = max(max_len, n - start);
        
        return max_len;
    }
};