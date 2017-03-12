class Solution {
public:
    vector<string> ret;
    void dfs(const int& index, const string& s, const vector<bool>& canBreak, vector<int>& cut, unordered_set<string>& wordDict) {
        if(index == s.size()) {
            if(cut.size() == 0) {
                ret.push_back(s);
                return ;
            }
            string cur;
            int k = 0;
            for(size_t j = 0;j < s.size();++j) {
                if(j < cut[k]) {
                    cur += s[j];
                } else if(j == cut[k]) {
                    cur += ' ';
                    k++;
                    cur += s[j];
                }
            }
            ret.push_back(cur);
            return ;
        }
        
        for(size_t i = 1;i <= s.size() - index;++i) {
            if(wordDict.find(s.substr(index, i)) != wordDict.end() && canBreak[index + i]) {
                cut.push_back(index + i);
                dfs(index + i, s, canBreak, cut, wordDict);
                cut.pop_back();
            }
        }
    }


    vector<string> wordBreak(string s, unordered_set<string>& wordDict) {
        vector<bool> canBreak(s.size() + 1, false);
        canBreak[s.size()] = true;
        for(int i = s.size() - 1;i >= 0;--i) {
            for(int j = s.size();j > i;--j) {
                if(canBreak[j] && wordDict.find(s.substr(i, j - i)) != wordDict.end()) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        vector<int> cut;
        dfs(0, s, canBreak, cut, wordDict);
        
        return ret;
    }
};