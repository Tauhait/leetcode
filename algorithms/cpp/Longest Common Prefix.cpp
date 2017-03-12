class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ret;
        if(strs.size() == 0) return ret;
        int j = 0;
        while(1) {
            if(strs[0].size() < j + 1) return ret;
            char c = strs[0][j];
            for(size_t i = 1;i < strs.size();++i) {
                if(strs[i].size() < j + 1) return ret;
                if(strs[i][j] != c) return ret;
            }
            ret += c;
            j++;
        }
    }
};