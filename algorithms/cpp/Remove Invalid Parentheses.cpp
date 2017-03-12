class Solution {
public:
    int found;
    void dfs(const string& s, const size_t& index, const int& left, const string& cur, vector<string>& ret) {
        if(s.size() == index) {
            if(left == 0) {
                if(ret.size() == 0) {
                    ret.push_back(cur);
                } else {
                    if(cur.size() == ret.back().size()) {
                        ret.push_back(cur);
                    } else {
                        found = 1;
                        return ;
                    }
                }
            }
            return ;
        } 
        
        //if(found == 1) return ;
        
        if(s[index] != ')' && s[index] != '(') {
            dfs(s, index + 1, left, cur + s[index], ret);
        } else if(s[index] == '(') {
            dfs(s, index + 1, left + 1, cur + s[index], ret);
        } else if(s[index] == ')' && left > 0) {
            dfs(s, index + 1, left - 1, cur + s[index], ret);
        }
        
        if(s[index] == ')') {
            size_t i = index;
            while(i + 1 < s.size() && s[i] == ')' && s[i + 1] == ')' ) i++;
            dfs(s, i + 1, left, cur, ret);
        } else if(s[index] == '(') {
            size_t i = index;
            while(i + 1 < s.size() && s[i] == '(' && s[i + 1] == '(') i++;
            dfs(s, i + 1, left, cur, ret);
        }
    }
    
    vector<string> removeInvalidParentheses(string s) {
        vector<string> ret;
        if(s.size() == 0) {
            ret.push_back("");
            return ret;
        }
        found = 0;
        string cur;
        dfs(s, 0, 0, cur, ret);
        
        return ret;
    }
};