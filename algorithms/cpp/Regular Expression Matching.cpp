class Solution {
public:
    bool match;
    void dfs(const string& s, const size_t& sindex, const string& p, const size_t& pindex) {
        if(match || sindex == s.size() && pindex == p.size()) {
            match = true;
            return ;
        }
        
        if(pindex >= p.size()) {
            return ;
        }
        
        if(pindex + 1 < p.size() && p[pindex + 1] == '*') {
            dfs(s, sindex, p, pindex + 2);
            for(int i = 0;i < s.size() - sindex;++i) {
                if(p[pindex] == '.' || s[sindex + i] == p[pindex]) {
                    dfs(s, sindex + i + 1, p, pindex + 2);
                } else {
                    return ;
                };
            }
            return;
        }
        
        if(sindex >= s.size()) {
            return ;
        }
        
        if(p[pindex] == '.' || s[sindex] == p[pindex]) {
            dfs(s, sindex + 1, p, pindex + 1);
        }
    }
    
    bool isMatch(string s, string p) {
        if(s.size() == 0 && p.size() == 0) {
            return true;
        } else if(s.size() != 0 && p.size() == 0) {
            return false;
        } else if(s.size() != 0 && p.size() != 0) {
            if(p[0] == '*') {
                return false;
            }
        }

        match = false;
        dfs(s, 0, p, 0);   
        return match;
    }
};

/*
"" ".*"
"a" "ab*"
"abcd" "d*"
"caaaaccabcacbaac" "b*.*..*bba.*bc*a*bc"
"aaaaaaaaaaaaab" "a*a*a*a*a*a*a*a*a*a*c"
*/