class Solution {
public:
    bool wordBreak(string s, unordered_set<string>& wordDict) {
        bool canBreak[s.size() + 1] = {false};
        canBreak[s.size()] = true;
        for(int i = s.size() - 1;i >= 0;--i) {
            for(int j = s.size();j > i;--j) {
                if(canBreak[j] && wordDict.find(s.substr(i, j - i)) != wordDict.end()) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        
        return canBreak[0];
    }
};