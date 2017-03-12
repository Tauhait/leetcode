class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> replace;
        if(s.size() != t.size()) {
            return false;
        }
        unordered_set<char> used;
        
        for(size_t i = 0;i < s.size();++i) {
            if(replace.find(s[i]) == replace.end()) {
                if(used.find(t[i]) != used.end()) {
                    return false;    
                }
                
                replace.insert(make_pair(s[i], t[i]));
                used.insert(t[i]);
            } else {
                if(replace[s[i]] != t[i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
};