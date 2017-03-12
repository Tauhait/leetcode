class Solution {
public:
    vector<string> match;
    bool found;
    void dfs(const string& pattern, const size_t& ps, const string& str, const size_t& ss) {
        if(found == true) return;
        if(ps == pattern.size() && ss == str.size()) {
            int t = true;
            for(int i = 0;i < match.size();++i) {
                if(t == false) break;
                for(int j = i + 1;j < match.size();++j) {
                    if(match[i] == match[j] && match[i] != "") {
                        t = false;
                        break;
                    }
                }
            }
            found = t;
        }
        
        if(ps >= pattern.size() || ss >= str.size()) return;
        
        if(match[pattern[ps] - 'a'] == "") {
            for(size_t i = 1;i <= str.size() - ss;++i) {
                match[pattern[ps] - 'a'] = str.substr(ss, i);
                dfs(pattern, ps + 1, str, ss + i);
                match[pattern[ps] - 'a'] = "";
            }
        } else {
            if(str.substr(ss, match[pattern[ps] - 'a'].size()) != match[pattern[ps] - 'a']) return;
            
            dfs(pattern, ps + 1, str, ss + match[pattern[ps] - 'a'].size());
        }
    }
    
    bool wordPatternMatch(string pattern, string str) {
        if(pattern.size() != 0 && str.size() == 0) return false;
        if(pattern.size() == 0 && str.size() != 0) return false;
        if(pattern.size() <= 1) return true;
        
        match.resize(26);
        for(int i = 0;i < 26;++i) {
            match[i] = "";
        }
        found = false;
        dfs(pattern, 0, str, 0);
        return found;
    }
};